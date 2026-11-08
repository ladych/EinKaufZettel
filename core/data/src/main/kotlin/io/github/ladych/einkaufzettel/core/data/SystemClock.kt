package io.github.ladych.einkaufzettel.core.data

import io.github.ladych.einkaufzettel.core.domain.Clock
import java.time.Instant

/** The real wall clock of the device. */
object SystemClock : Clock {
    override fun now(): Instant = Instant.now()
}
