package com.steve.interview.dvt.weather.data

import com.steve.interview.dvt.weather.api.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(val api: WeatherAPI) {

    suspend fun getCurrentWeather() = api.getCurrentWeather() //TODO: Check weather its the correct way to make this call (Suspend function 'getCurrentWeather' should be called only from a coroutine or another suspend function)

    suspend fun getForecast() = api.getForecast() //TODO: Same as above

}