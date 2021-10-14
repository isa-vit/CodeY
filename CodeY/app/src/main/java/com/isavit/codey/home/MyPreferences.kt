package com.isavit.codey.home

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager

class MyPreferences(context: Context?) {
    companion object {
        private const val DARK_STATUS = "com.isavit.codey.DARK_STATUS"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var darkMode = preferences.getInt(DARK_STATUS, AppCompatDelegate.MODE_NIGHT_NO)
        set(value) = preferences.edit().putInt(DARK_STATUS, value).apply()
}