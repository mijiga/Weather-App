package com.steve.interview.dvt.weather.data.model

data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<CurrentWeather>,
    val message: Int
)