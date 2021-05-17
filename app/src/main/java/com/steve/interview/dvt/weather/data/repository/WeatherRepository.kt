package com.steve.interview.dvt.weather.data.repository

import com.steve.interview.dvt.weather.api.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(val api: WeatherAPI) {

    suspend fun getCurrentWeather(lat: Double, lon: Double) = api.getCurrentWeather(lat, lon)

    suspend fun getForecast(lat: Double, lon: Double) = api.getForecast(lat,lon)

}