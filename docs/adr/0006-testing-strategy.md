# 6. Testing strategy

Date: 2026-11-08 · Status: accepted

## Context

The project is developed test-first. Most tests should run on the JVM in milliseconds, without an emulator.

## Decision

- Pure Kotlin modules use JUnit 6 (Jupiter, including parameterized tests) with Kotest assertions and Kotest
  property testing. The Kotest test engine is not used, which keeps the JUnit Platform setup simple under
  Gradle 9.
- Android modules use JUnit 4 for local unit tests; Robolectric and Compose UI tests follow when screens grow.
- Fakes are preferred over mocks. Time and IDs are injected (`Clock`, later `IdGenerator`).
- Kover verifies at least 90 % line coverage in `:core:domain` and `:core:parsing` – as an indicator, not
  as a goal.

## Consequences

- `./gradlew test koverVerify` runs the whole fast suite; CI runs it on every push.
