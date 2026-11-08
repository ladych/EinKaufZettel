# EinKaufZettel

[![CI](https://github.com/ladych/EinKaufZettel/actions/workflows/ci.yml/badge.svg)](https://github.com/ladych/EinKaufZettel/actions/workflows/ci.yml)
[![License: GPL-3.0-or-later](https://img.shields.io/badge/license-GPL--3.0--or--later-blue.svg)](LICENSE)

A local-first shopping list for Android with voice input, product categories and a summary after every
shopping trip. Free software, made for [F-Droid](https://f-droid.org).

> **Status:** early development – milestone M0 (project skeleton). The app starts, but has no features yet.

## Planned features

- **Voice input with live text:** say "two litres of milk, three apples and bread" and watch three items appear.
- **Categories in store order:** items are grouped and sorted the way you walk through your shop.
- **Shopping summary:** bought vs. open items, items per category, duration; carry open items over.
- **Local first:** no account, no server, no tracking, no `INTERNET` permission. Your data stays on your phone.
- **English and German**, selectable per app on Android 13+.

## Architecture

Clean Architecture with ports and adapters. All dependencies point inwards to the pure Kotlin core.

| Module | Kind | Responsibility |
| --- | --- | --- |
| `:app` | Android app | Activity, Navigation 3, starts Koin with all modules |
| `:feature:shopping` | Android library | Shopping list screen and ViewModel |
| `:core:domain` | Kotlin/JVM | Entities, value objects, use cases, ports |
| `:core:parsing` | Kotlin/JVM | Turns spoken or typed text into shopping items |
| `:core:data` | Android library | Persistence and system adapters (Room follows in M2) |
| `:core:speech` | Android library | Speech recognition adapters (follows in M3) |
| `:core:designsystem` | Android library | Compose theme and shared components |
| `:core:testing` | Kotlin/JVM | Test doubles such as `FixedClock` |

Decisions are recorded in [`docs/adr`](docs/adr).

## Building

Requirements: JDK 17 or newer (CI uses 21) and the Android SDK.

```bash
./gradlew assembleDebug                                   # build the app
./gradlew spotlessCheck detekt test koverVerify lint      # everything CI checks
./gradlew spotlessApply                                   # fix formatting
```

## Working on the code

- **Test first.** New behaviour starts with a failing test (red), then the simplest code that passes (green),
  then refactoring. Domain and parsing logic are pure Kotlin and run in milliseconds.
- **Dependency rule.** Feature modules must not depend on `:core:data`, `:core:speech` or `:app`; the build
  fails if they do.
- **Formatting** is ktlint via Spotless; static analysis is detekt; Android Lint treats warnings as errors.

## License

EinKaufZettel is licensed under the [GNU General Public License v3.0 or later](LICENSE).

---

## Deutsch

EinKaufZettel ist eine Einkaufslisten-App für Android: komplett offline, per Sprache befüllbar, mit
Kategorien in Laden-Reihenfolge und einer Zusammenfassung nach jedem Einkauf. Kein Konto, kein Tracking,
keine Netzwerkberechtigung. Die App ist freie Software unter GPL-3.0-or-later und erscheint auf F-Droid.
