package com.steve.interview.dvt.weather.data.repository

import com.steve.interview.dvt.weather.data.sample.testTheme

class FakeThemeRepository : ThemeRepository {

    override fun getTheme(): Int {
        return testTheme
    }

    override fun setTheme(theme: Int) {
        testTheme = theme
    }
}
