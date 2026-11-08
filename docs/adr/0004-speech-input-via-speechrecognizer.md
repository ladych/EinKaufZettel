# 4. Speech input via the platform SpeechRecognizer

Date: 2026-11-08 · Status: accepted

## Context

Voice input is a core feature. The app must stay small, free of proprietary libraries and must not need the
`INTERNET` permission.

## Decision

- The MVP uses its own voice sheet with live partial results, backed by Android's `SpeechRecognizer` API.
  Recognition itself is done by the device's recognition service.
- When `isOnDeviceRecognitionAvailable` is true, `createOnDeviceSpeechRecognizer` is preferred so that no
  audio leaves the device.
- If no recognition service exists (typical without Google apps), the app points to free services such as
  Marmalade STT or Whisper IME and falls back to `RecognizerIntent` or the keyboard.
- The domain sees only the `SpeechToText` port, which emits level, partial and final events as a `Flow`.
- An embedded offline engine (Vosk) may follow later as a separate build flavor.

## Consequences

- No speech model in the APK and no network access in the app itself.
- The quality of recognition depends on the installed service; the parser has to be robust.
- The live-text UI is tested with a fake `SpeechToText`, without a microphone.
