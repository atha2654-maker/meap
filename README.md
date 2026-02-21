# MEAP Java-only Android APK

This repository now contains a minimal Android app written in **Java only** (no Kotlin source files).

## Build debug APK

```bash
export ANDROID_SDK_ROOT=/workspace/android-sdk
export ANDROID_HOME=/workspace/android-sdk
gradle assembleDebug
```

Generated APK:

- `app/build/outputs/apk/debug/app-debug.apk`
