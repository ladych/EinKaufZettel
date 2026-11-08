plugins {
    alias(libs.plugins.einkaufzettel.jvm.library)
}

dependencies {
    api(project(":core:domain"))
}
