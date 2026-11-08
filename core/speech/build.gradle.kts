plugins {
    alias(libs.plugins.einkaufzettel.android.library)
}

dependencies {
    implementation(project(":core:domain"))
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
}
