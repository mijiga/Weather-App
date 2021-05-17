package com.steve.interview.dvt.weather.api

import retrofit2.http.GET

interface WeatherAPI {

    @GET("weather?")
    suspend fun getCurrentWeather()

    @GET("forecast?")
    suspend fun getForecast()

}