package com.steve.interview.dvt.weather.data.repository

import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.data.sample.testForecastResponse
import com.steve.interview.dvt.weather.data.sample.testWeather
import retrofit2.Response

class FakeWeatherRepository : WeatherRepositoryInt {

    private var returnNetworkError = false

    override suspend fun getCurrentWeather(lat: Double, lon: Double): Response<CurrentWeather> {
        return if (returnNetworkError) {
            Response.error(401, null)
        } else {
            Response.success(testWeather)
        }
    }

    override suspend fun getForecast(lat: Double, lon: Double): Response<ForecastResponse> {
        return if (returnNetworkError) {
            Response.error(401, null)
        } else {
            Response.success(testForecastResponse)
        }
    }
}
