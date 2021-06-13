package com.steve.interview.dvt.weather.data.repository

import android.content.SharedPreferences
import com.steve.interview.dvt.weather.util.Constants.Companion.DEFAULT_LAT
import com.steve.interview.dvt.weather.util.Constants.Companion.DEFAULT_LON
import javax.inject.Inject

class DefaultLocationRepository @Inject constructor(private val sharedPreferences: SharedPreferences) :
    LocationRepository {

    override fun getLatitude() =
        sharedPreferences.getFloat("latitude", DEFAULT_LAT.toFloat()).toDouble()

    override fun setLatitude(latitude: Double) =
        sharedPreferences.edit().putFloat("latitude", latitude.toFloat()).apply()

    override fun getLongitude() =
        sharedPreferences.getFloat("longitude", DEFAULT_LON.toFloat()).toDouble()

    override fun setLongitude(longitude: Double) =
        sharedPreferences.edit().putFloat("longitude", longitude.toFloat()).apply()
}
