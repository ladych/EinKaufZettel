import com.android.build.api.dsl.Lint
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun VersionCatalog.library(alias: String): Provider<MinimalExternalModuleDependency> = findLibrary(alias).get()

/** ":core:domain" becomes "io.github.ladych.einkaufzettel.core.domain". */
internal fun Project.androidNamespace(): String =
    ProjectConfig.BASE_NAMESPACE + path.replace(':', '.').replace('-', '_')

internal fun Project.configureKotlinJvmTarget() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions.jvmTarget.set(ProjectConfig.JVM_TARGET)
    }
}

internal fun Lint.configureDefaults() {
    warningsAsErrors = true
    abortOnError = true
    // Version checks need network access and would make the build depend on the release calendar.
    disable +=
        setOf(
            "AndroidGradlePluginVersion",
            "GradleDependency",
            "NewerVersionAvailable",
            "ObsoleteLintCustomCheck",
            "OldTargetApi",
        )
}

/** Enforces the dependency rule from docs/adr/0002-module-structure.md at configuration time. */
internal fun Project.forbidProjectDependencies(vararg forbiddenPaths: String) {
    val forbidden = forbiddenPaths.toSet()
    val modulePath = path
    configurations.configureEach {
        dependencies.withType<ProjectDependency>().configureEach {
            if (this.path in forbidden) {
                throw GradleException(
                    "Module $modulePath must not depend on ${this.path} (see docs/adr/0002-module-structure.md)",
                )
            }
        }
    }
}
