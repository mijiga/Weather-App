package com.steve.interview.dvt.weather.data.repository

import android.content.SharedPreferences
import com.steve.interview.dvt.weather.R
import javax.inject.Inject

class ThemeRepository @Inject constructor(private val sharedPreferences: SharedPreferences){

    fun getTheme() = sharedPreferences.getInt("theme", R.style.Theme_Sunny)

    fun setTheme(theme: Int) = sharedPreferences.edit().putInt("theme", theme).apply()
}