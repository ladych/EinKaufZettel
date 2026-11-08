plugins {
    alias(libs.plugins.einkaufzettel.jvm.library)
    alias(libs.plugins.kover)
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
