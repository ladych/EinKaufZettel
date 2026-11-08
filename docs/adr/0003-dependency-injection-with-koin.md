# 3. Dependency injection with Koin

Date: 2026-11-08 · Status: accepted

## Context

Constructor injection keeps classes testable regardless of the framework. Wiring by hand becomes tedious once
there are repositories, use cases and several ViewModels.

## Decision

Koin from the start. Every Gradle module contributes its own Koin module (`dataModule`, `speechModule`,
`shoppingFeatureModule`, …); `:app` collects them in `appModules` and starts Koin in the `Application`.
A unit test calls Koin's `verify()` on all modules so that missing definitions fail in CI, not at runtime.

## Consequences

- No annotation processing, no generated code, fast builds.
- Classes stay framework-free: they receive dependencies through their constructors and never call Koin.
