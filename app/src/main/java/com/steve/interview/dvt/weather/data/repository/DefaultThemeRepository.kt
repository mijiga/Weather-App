package com.steve.interview.dvt.weather.data.repository

import android.content.SharedPreferences
import com.steve.interview.dvt.weather.R
import javax.inject.Inject

class DefaultThemeRepository @Inject constructor(private val sharedPreferences: SharedPreferences) :
    ThemeRepository {

    override fun getTheme() = sharedPreferences.getInt("theme", R.style.Theme_Sunny)

    override fun setTheme(theme: Int) = sharedPreferences.edit().putInt("theme", theme).apply()
}