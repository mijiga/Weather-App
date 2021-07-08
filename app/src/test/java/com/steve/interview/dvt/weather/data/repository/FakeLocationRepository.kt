package com.steve.interview.dvt.weather.data.repository

import com.steve.interview.dvt.weather.util.Constants.Companion.DEFAULT_LAT
import com.steve.interview.dvt.weather.util.Constants.Companion.DEFAULT_LON

class FakeLocationRepository : LocationRepository {

    override fun getLatitude(): Double {
        return DEFAULT_LAT
    }

    override fun setLatitude(latitude: Double) {
    }

    override fun getLongitude(): Double {
        return DEFAULT_LON
    }

    override fun setLongitude(longitude: Double) {
    }
}
