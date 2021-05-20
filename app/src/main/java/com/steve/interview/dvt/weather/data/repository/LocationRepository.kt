package com.steve.interview.dvt.weather.data.repository

import android.content.SharedPreferences
import com.steve.interview.dvt.weather.util.Constants

interface LocationRepository {

    fun getLatitude(): Double
    fun setLatitude(latitude: Double)

    fun getLongitude(): Double
    fun setLongitude(longitude: Double)

}