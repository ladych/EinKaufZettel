package io.github.ladych.einkaufzettel.core.domain

import java.time.Instant

/** Source of the current time. Injected everywhere so that time-dependent logic stays testable. */
public fun interface Clock {
    public fun now(): Instant
}
