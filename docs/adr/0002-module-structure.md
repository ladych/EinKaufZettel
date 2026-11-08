# 2. Module structure and dependency rule

Date: 2026-11-08 · Status: accepted

## Context

The business logic (parsing spoken text, merging quantities, building the shopping summary) must be testable
in milliseconds and must not know about Android, Room or a speech engine.

## Decision

Clean Architecture with ports and adapters, split into Gradle modules:

- `:core:domain` and `:core:parsing` are pure Kotlin/JVM modules with explicit API mode.
  `:core:parsing` uses the value objects of `:core:domain`, never the other way round.
- `:core:data` and `:core:speech` are Android adapters that implement ports defined in `:core:domain`.
- `:feature:*` modules contain screens and ViewModels. They may use `:core:domain` and
  `:core:designsystem`, but never `:core:data`, `:core:speech` or `:app`.
- `:app` is the composition root: it starts Koin with the modules of all layers.

The rule is enforced by the build itself: pure Kotlin modules cannot import Android classes, and the feature
convention plugin fails the configuration when a feature module declares a forbidden project dependency.

## Consequences

- Wrong dependencies fail fast and locally, not in review.
- A dedicated architecture test library (e.g. Konsist) is not needed for now; it can be added if rules
  inside a module become necessary.
- Start lean: one feature module until it becomes too large to navigate.
