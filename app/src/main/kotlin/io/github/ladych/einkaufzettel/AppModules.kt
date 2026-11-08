package io.github.ladych.einkaufzettel

import io.github.ladych.einkaufzettel.core.data.dataModule
import io.github.ladych.einkaufzettel.core.speech.speechModule
import io.github.ladych.einkaufzettel.feature.shopping.shoppingFeatureModule
import org.koin.core.module.Module

/** Every Koin module of the app. Each Gradle module contributes its own. */
val appModules: List<Module> =
    listOf(
        dataModule,
        speechModule,
        shoppingFeatureModule,
    )
