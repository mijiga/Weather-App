package com.steve.interview.dvt.weather.ui.mainActivity

import com.steve.interview.dvt.weather.data.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) {

    init {

    }

    fun getCurrentWeather(country: String, city: String){

    }

    fun getForecast(country: String, city: String){

    }

}