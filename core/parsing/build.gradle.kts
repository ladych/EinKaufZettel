plugins {
    alias(libs.plugins.einkaufzettel.jvm.library)
    alias(libs.plugins.kover)
}

dependencies {
    api(project(":core:domain"))
}

kover {
    useJacoco()
    reports {
        verify {
            rule {
                minBound(90)
            }
        }
    }
}
