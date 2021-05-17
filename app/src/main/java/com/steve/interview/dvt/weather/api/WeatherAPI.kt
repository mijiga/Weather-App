package com.steve.interview.dvt.weather.api

import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.util.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("weather?")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = API_KEY
    ): CurrentWeather

    @GET("forecast/daily?")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("cnt") cnt: Int = 5,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = API_KEY
    ): ForecastResponse

}