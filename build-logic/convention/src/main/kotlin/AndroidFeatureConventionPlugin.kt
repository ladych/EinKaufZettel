import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/** A feature module: Compose screen + ViewModel, wired with Koin, without access to data or speech adapters. */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("einkaufzettel.android.library")
            pluginManager.apply("einkaufzettel.android.compose")

            dependencies {
                add("implementation", platform(libs.library("koin-bom")))
                add("implementation", libs.library("koin-androidx-compose"))
                add("implementation", libs.library("koin-compose-viewmodel"))
                add("implementation", libs.library("koin-core-viewmodel"))
                add("implementation", libs.library("androidx-lifecycle-runtime-compose"))
                add("implementation", libs.library("androidx-lifecycle-viewmodel-compose"))
                add("testImplementation", libs.library("junit4"))
            }

            forbidProjectDependencies(":app", ":core:data", ":core:speech")
        }
    }
}
