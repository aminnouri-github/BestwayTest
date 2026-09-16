# راهنمای گرفتن APK (بدون نصب چیزی روی سیستم شما)

این پوشه یک فایل GitHub Actions (`.github/workflows/build.yml`) داره که به‌صورت خودکار پروژه رو build می‌کنه و APK می‌سازه.

## مراحل:
1. یک اکانت رایگان در https://github.com بسازید (اگر ندارید).
2. یک ریپازیتوری جدید بسازید (خالی، بدون README).
3. تمام محتوای این پوشه (BestwayTest) رو در همون ریپو آپلود کنید:
   - در صفحه ریپو روی "uploading an existing file" کلیک کنید
   - همه‌ی فایل‌ها و پوشه‌ها (شامل .github) رو بکشید و رها کنید
   - Commit کنید
4. به تب **Actions** در بالای صفحه ریپو برید. یک workflow به اسم "Build APK" به‌طور خودکار شروع میشه (چند دقیقه طول می‌کشه).
5. وقتی سبز شد (تیک ✅)، روی همون run کلیک کنید و پایین صفحه، بخش **Artifacts** رو ببینید — یک فایل zip به اسم `BestwayTest-debug-apk` اونجاست. دانلودش کنید و APK داخلشه.

اگر ترجیح می‌دید، می‌تونید به‌جای آپلود دستی، با git از خط فرمان هم push کنید:
```
git init
git add .
git commit -m "init"
git remote add origin <آدرس ریپوی شما>
git push -u origin main
```
