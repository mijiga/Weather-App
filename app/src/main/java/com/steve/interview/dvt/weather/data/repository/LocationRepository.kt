package com.steve.interview.dvt.weather.data.repository

import android.content.SharedPreferences
import com.steve.interview.dvt.weather.util.Constants.Companion.DEFAULT_LAT
import com.steve.interview.dvt.weather.util.Constants.Companion.DEFAULT_LON
import javax.inject.Inject

class LocationRepository @Inject constructor(private val sharedPreferences: SharedPreferences){

    fun getLatitude() = sharedPreferences.getFloat("latitude", DEFAULT_LAT.toFloat()).toDouble()
    fun setLatitude(latitude: Double) = sharedPreferences.edit().putFloat("latitude", latitude.toFloat())

    fun getLongitude() = sharedPreferences.getFloat("longitude", DEFAULT_LON.toFloat()).toDouble()
    fun setLongitude(longitude: Double) = sharedPreferences.edit().putFloat("longitude", longitude.toFloat())

}