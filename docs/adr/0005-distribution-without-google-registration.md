# 5. Distribution via F-Droid without Google developer registration

Date: 2026-11-08 · Status: accepted

## Context

Google's Android developer verification requires apps on certified devices to be registered by a verified
developer. Enforcement started on 30 September 2026 in Brazil, Indonesia, Singapore and Thailand; a global
rollout is announced for 2027.

## Decision

- EinKaufZettel is distributed through F-Droid, aiming for a reproducible build signed with the
  developer's own key.
- There is no registration and no identity verification with Google.
- The application ID `io.github.ladych.einkaufzettel` derives from the GitHub Pages domain and needs no
  registration either.

## Consequences

- After the global rollout, users of certified devices install the app via ADB or Google's "advanced flow".
  Devices without Google certification, for example with custom ROMs, are not affected.
- The release APK must not contain Google-encrypted dependency metadata (`dependenciesInfo` is disabled).
