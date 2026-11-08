plugins {
    alias(libs.plugins.einkaufzettel.jvm.library)
    alias(libs.plugins.einkaufzettel.jvm.coverage)
}

dependencies {
    api(project(":core:domain"))
}
