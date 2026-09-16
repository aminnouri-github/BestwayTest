package com.bestway.navigator

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {
    private lateinit var root: LinearLayout
    private var night = true
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); showHome() }

    private fun showHome() {
        root = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL; setPadding(28, 32, 28, 20); gravity = Gravity.CENTER_HORIZONTAL }
        applyTheme()
        val title = TextView(this).apply { text = "Bestway\nمسیر بهتر، همیشه در دسترس شما"; textSize = 25f; gravity = Gravity.CENTER; setPadding(0, 10, 0, 30) }
        root.addView(title, LinearLayout.LayoutParams(-1, -2))
        val origin = EditText(this).apply { hint = "مبدا را وارد کنید" }
        val destination = EditText(this).apply { hint = "مقصد را وارد کنید" }
        root.addView(origin, lp()); root.addView(destination, lp())
        val preview = Button(this).apply { text = "نمایش مسیر"; setOnClickListener { showRoute(origin.text.toString(), destination.text.toString()) } }
        root.addView(preview, lp())
        val saved = Button(this).apply { text = "مسیرهای من"; setOnClickListener { Toast.makeText(this@MainActivity, "در نسخه بعدی فعال می‌شود", Toast.LENGTH_SHORT).show() } }
        root.addView(saved, lp())
        val theme = Button(this).apply { text = "تغییر حالت نمایش"; setOnClickListener { night = !night; applyTheme() } }
        root.addView(theme, lp())
        setContentView(root)
    }
    private fun showRoute(o: String, d: String) {
        root.removeAllViews(); applyTheme()
        root.addView(TextView(this).apply { text = "نمایش مسیر\n${o.ifBlank { "موقعیت فعلی" }}  →  ${d.ifBlank { "مقصد آزمایشی" }}"; textSize = 22f; gravity = Gravity.CENTER; setPadding(0,20,0,25) }, lp())
        root.addView(TextView(this).apply { text = "نقشه نمایشی\n\n● مبدا  ━━━━━━━━  ● مقصد\n\nفاصله: ۱۲ کیلومتر     زمان: ۱۸ دقیقه"; textSize = 19f; gravity = Gravity.CENTER; setPadding(0,40,0,40) }, lp())
        root.addView(Button(this).apply { text = "شروع سفر"; setOnClickListener { Toast.makeText(this@MainActivity, "سفر آزمایشی شروع شد", Toast.LENGTH_LONG).show() } }, lp())
        root.addView(Button(this).apply { text = "بازگشت"; setOnClickListener { showHome() } }, lp())
    }
    private fun lp() = LinearLayout.LayoutParams(-1, -2).apply { setMargins(0, 12, 0, 12) }
    private fun applyTheme() { root.setBackgroundColor(Color.parseColor(if (night) "#071B33" else "#F5F8FC")); root.setTextColorCompat(if (night) Color.WHITE else Color.DKGRAY) }
    private fun LinearLayout.setTextColorCompat(c: Int) { for (i in 0 until childCount) (getChildAt(i) as? TextView)?.setTextColor(c) }
}
