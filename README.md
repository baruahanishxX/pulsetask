# PulseTask — Full Premium (offline) — GitHub Actions build ready

This project is the full offline version of **PulseTask** (Jetpack Compose, Room, WorkManager).  
It is configured to be built by **GitHub Actions** into a debug-signed APK you can download and sideload.

## Steps to get the APK (minimal internet + no SDK locally)

1. Create a new GitHub repository (private or public).  
2. Upload all files from this project (you can `git init`, add remote, push; or upload zip via web).  
   - If using the web UI, upload the ZIP and extract on the repo root (or use the "Upload files" button).
3. Make sure the workflow file is at `.github/workflows/build-apk.yml`.
4. Push to the `main` or `master` branch, or trigger the workflow manually in the Actions tab.
5. Wait for the workflow to finish (usually ~3–7 minutes).  
6. Open the workflow run, go to **Artifacts**, download `pulsetask-debug-apk` — that's `app-debug.apk`.
7. Transfer the APK to your phone (or download directly on phone) and install (enable Install from unknown sources if needed).

## Notes
- The APK is debug-signed and installable on devices for testing.
- No Firebase or cloud sync is included — offline-only.
- If you'd like, I can also produce an **installer APK** or a release-signed build; tell me and I'll add steps.

If you want, I can now:
- Produce a short `git` command sequence to upload the repo from your machine (small data) to GitHub.
- Or produce a downloadable ZIP here (so you can upload via GitHub web UI).  

Which do you prefer? (type `git-commands` or `download-zip`)
