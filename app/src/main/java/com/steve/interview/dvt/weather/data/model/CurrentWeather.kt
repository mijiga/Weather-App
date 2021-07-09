package com.steve.interview.dvt.weather.data.model

import java.text.SimpleDateFormat
import java.util.Date

data class CurrentWeather(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
) {
    fun getDay(): String {
        val sdf = SimpleDateFormat("EEEE")
        val dateFormat = Date(this.dt.toLong() * 1000)

        return sdf.format(dateFormat)
    }
}
