# MEAP Connect (Java-only Android Studio project)

A Java-only Android app scaffold that builds into a single APK and opens directly in Android Studio.

## Included feature screens

- Login tab: phone + email login flow with SMS/email code verification UI.
- Chat tab: individual chat, voice chat button, microphone input action, WhatsApp delegation input.
- Public tab: public chat, public conference, screen share and whiteboard actions.
- Events tab: latest MUN event details (location/fee/link enrollment) + past event prize list.
- Members tab: ordered member list with portfolio + committee and one-tap Excel-compatible CSV export.
- Profile tab: editable profile details + changeable profile photo.
- Planner tab: date-based planning.
- Admin tab: owner/admin profile panels.

## Build APK

```bash
export ANDROID_SDK_ROOT=/workspace/android-sdk
export ANDROID_HOME=/workspace/android-sdk
gradle assembleDebug
```

APK output:

- `app/build/outputs/apk/debug/app-debug.apk`

> Note: real SMS/email OTP delivery, real-time voice/video calls, and conference signaling require backend services (e.g., Firebase/Twilio/WebRTC server) and are currently represented with UI + local action stubs.
