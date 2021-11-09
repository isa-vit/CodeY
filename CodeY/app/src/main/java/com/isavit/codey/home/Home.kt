package com.isavit.codey.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.isavit.codey.R
import com.isavit.codey.home.MyPrograms
import kotlinx.android.synthetic.main.activity_home.*


class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val currentTheme = MyPreferences(this).darkMode
        applyTheme(currentTheme)
        val myprog = findViewById<TextView>(R.id.myPrograms)
        val clickscanrun = findViewById<TextView>(R.id.clickscanrun)
        val notes = findViewById<TextView>(R.id.notes)
        val themeSwitch = findViewById<ImageButton>(R.id.themeSwitch)

        myprog.setOnClickListener {
            val intent = Intent(this, MyPrograms::class.java)
            startActivity(intent)
        }

        clickscanrun.setOnClickListener {
            val intent = Intent(this, ClickScanRun::class.java)
            startActivity(intent)
        }

        notes.setOnClickListener {
            val intent = Intent(this, Notes::class.java)
            startActivity(intent)
        }
        themeSwitch.setOnClickListener {
            if (currentTheme == AppCompatDelegate.MODE_NIGHT_NO) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
                MyPreferences(this).darkMode = AppCompatDelegate.MODE_NIGHT_YES
                themeSwitch.setImageResource(R.drawable.bulboff)

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
                MyPreferences(this).darkMode = AppCompatDelegate.MODE_NIGHT_NO
                themeSwitch.setImageResource(R.drawable.bulbon)

            }
        }

    }

    private fun applyTheme(theme: Int) {
        AppCompatDelegate.setDefaultNightMode(theme)
        delegate.applyDayNight()
        if (theme == AppCompatDelegate.MODE_NIGHT_NO) {
            themeSwitch.setImageResource(R.drawable.bulbon)
        } else {
            themeSwitch.setImageResource(R.drawable.bulboff)

        }
    }
}