# MEAP Connect (Java-only Android Studio project)

A Java-only Android app scaffold that builds into a single APK and opens directly in Android Studio.

## Features included

1. Voice call and video call actions on top-right app bar.
2. Individual chat with integrated call/video buttons.
3. Login with phone + email and OTP-style SMS/email verification UI.
4. Automatic Excel-compatible sheet (CSV) update with ordered members, portfolio, committee.
5. Separate tab for each area.
6. Profile tab with editable profile photo/details.
7. Event tab with latest MUN events, location, fee, enrollment link + button.
8. Separate past-event tab with prize highlights.
9. Admin and owner profile tab.
10. Mobile data / network awareness in top bar.
11. Personalized app icon.
12. Voice message input via speech-to-text trigger.
13. WhatsApp delegation input.
14. Voice chat action.
15. Public chat action.
16. Public conference action.
17. Conference controls including screen-share and whiteboard entry actions.
18. Planner with dates.
19. Eye-catchy Material UI theme.


## Open in Android Studio (recommended)

1. Open **Android Studio** → **Open** → select this project folder (`meap`).
2. Let Gradle sync using the included wrapper (`gradlew`).
3. If prompted for SDK location, either:
   - set it in Android Studio SDK Manager, or
   - copy `local.properties.example` to `local.properties` and set `sdk.dir` for your machine.
4. Select an emulator/device and press **Run**.
5. For APK file directly: **Build > Build Bundle(s) / APK(s) > Build APK(s)**.

## Build APK (easy in Android Studio)

- Open this folder in Android Studio and click **Run** or **Build APK**.
- Or build from terminal:

```bash
./gradlew assembleDebug
```

APK output:

- `app/build/outputs/apk/debug/app-debug.apk`

> Note: Real SMS/email OTP delivery, real-time voice/video calls, and conference signaling need backend services (Firebase/Twilio/WebRTC). This project provides Java UI + app structure stubs ready for integration.
