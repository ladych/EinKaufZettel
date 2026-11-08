package io.github.ladych.einkaufzettel.feature.shopping

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val shoppingFeatureModule =
    module {
        viewModelOf(::ShoppingListViewModel)
    }
