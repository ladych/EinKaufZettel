plugins {
    `kotlin-dsl`
}

group = "io.github.ladych.einkaufzettel.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "einkaufzettel.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "einkaufzettel.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = "einkaufzettel.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "einkaufzettel.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("jvmLibrary") {
            id = "einkaufzettel.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("jvmCoverage") {
            id = "einkaufzettel.jvm.coverage"
            implementationClass = "JvmCoverageConventionPlugin"
        }
        register("detekt") {
            id = "einkaufzettel.detekt"
            implementationClass = "DetektConventionPlugin"
        }
    }
}
