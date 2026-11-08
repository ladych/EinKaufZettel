import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.named
import org.gradle.testing.jacoco.tasks.JacocoCoverageVerification
import org.gradle.testing.jacoco.tasks.JacocoReport
import java.math.BigDecimal

/** Line coverage gate for pure Kotlin modules, measured with Gradle's built-in JaCoCo plugin. */
class JvmCoverageConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("jacoco")

            tasks.named<JacocoReport>("jacocoTestReport") {
                dependsOn(tasks.named("test"))
                reports {
                    xml.required.set(true)
                    html.required.set(true)
                }
            }

            tasks.named<JacocoCoverageVerification>("jacocoTestCoverageVerification") {
                dependsOn(tasks.named("test"))
                violationRules {
                    rule {
                        limit {
                            counter = "LINE"
                            minimum = MIN_LINE_COVERAGE
                        }
                    }
                }
            }

            tasks.named("check") {
                dependsOn("jacocoTestCoverageVerification")
            }
        }
    }

    private companion object {
        val MIN_LINE_COVERAGE: BigDecimal = BigDecimal("0.90")
    }
}
