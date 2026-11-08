package io.github.ladych.einkaufzettel.core.data

import io.github.ladych.einkaufzettel.core.domain.Clock
import org.koin.dsl.module

/** Koin bindings for persistence and system adapters. Room repositories follow in M2. */
val dataModule =
    module {
        single<Clock> { SystemClock }
    }
