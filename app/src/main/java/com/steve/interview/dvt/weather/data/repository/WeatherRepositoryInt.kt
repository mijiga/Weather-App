package com.steve.interview.dvt.weather.data.repository

import androidx.lifecycle.ViewModel
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import retrofit2.Response

interface WeatherRepositoryInt {

    suspend fun getCurrentWeather(lat: Double, lon: Double): Response<CurrentWeather>

    suspend fun getForecast(lat: Double, lon: Double): Response<ForecastResponse>

}