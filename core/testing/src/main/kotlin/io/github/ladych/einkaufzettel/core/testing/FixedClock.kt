package io.github.ladych.einkaufzettel.core.testing

import io.github.ladych.einkaufzettel.core.domain.Clock
import java.time.Duration
import java.time.Instant

/** A [Clock] for tests: stands still until it is moved forward explicitly. */
public class FixedClock(
    private var current: Instant = Instant.parse("2026-01-01T10:00:00Z"),
) : Clock {
    override fun now(): Instant = current

    public fun advanceBy(duration: Duration) {
        current = current.plus(duration)
    }
}
