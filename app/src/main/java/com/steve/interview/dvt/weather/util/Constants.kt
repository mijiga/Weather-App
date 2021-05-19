package com.steve.interview.dvt.weather.util

class Constants {

    companion object {

        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        const val API_KEY = "6597485cec3de440de83624771fcdd2e"

        const val DEFAULT_LAT = -13.9669
        const val DEFAULT_LON = 33.7873

        val CLEAR_RANGE = 800..800
        val CLOUDY_RANGE = 801..804
        val RAINY_RANGE = 500..504

        const val REQUEST_CODE_LOCATION_PERMISSION = 100



    }

}