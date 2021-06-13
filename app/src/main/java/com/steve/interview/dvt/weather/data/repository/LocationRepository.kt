package com.steve.interview.dvt.weather.data.repository

interface LocationRepository {

    fun getLatitude(): Double
    fun setLatitude(latitude: Double)

    fun getLongitude(): Double
    fun setLongitude(longitude: Double)
}
