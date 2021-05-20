package com.steve.interview.dvt.weather.data.repository

interface ThemeRepository {

    fun getTheme(): Int

    fun setTheme(theme: Int)
}