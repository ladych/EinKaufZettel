plugins {
    alias(libs.plugins.einkaufzettel.android.application)
    alias(libs.plugins.einkaufzettel.android.compose)
}

android {
    defaultConfig {
        applicationId = "io.github.ladych.einkaufzettel"
        versionCode = 1
        versionName = "0.1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    androidResources {
        // Only languages the app is actually translated into; drops the other locales of AndroidX libraries.
        localeFilters += setOf("en", "de")
        generateLocaleConfig = true
    }

    // F-Droid: no Google-encrypted dependency metadata in the APK.
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:speech"))
    implementation(project(":core:designsystem"))
    implementation(project(":feature:shopping"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    testImplementation(libs.junit4)
    testImplementation(libs.koin.test)
}
