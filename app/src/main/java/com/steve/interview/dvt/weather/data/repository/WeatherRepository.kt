package com.steve.interview.dvt.weather.data.repository

import com.steve.interview.dvt.weather.api.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherAPI) : WeatherRepositoryInt {

    override suspend fun getCurrentWeather(lat: Double, lon: Double) = api.getCurrentWeather(lat, lon)

    override suspend fun getForecast(lat: Double, lon: Double) = api.getForecast(lat,lon)

}