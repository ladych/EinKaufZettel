plugins {
    alias(libs.plugins.einkaufzettel.android.feature)
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:designsystem"))
}
