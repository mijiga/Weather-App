package com.steve.interview.dvt.weather.ui.mainActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    ViewModel() {//TODO: Check if theres any point of adding the @Inject notation

    val currentWeather: MutableLiveData<CurrentWeather> = MutableLiveData()
    val forecast: MutableLiveData<ForecastResponse> = MutableLiveData()

    init {
        this.getCurrentWeather(-13.9669,33.7873)
        this.getForecast(-13.9669,33.7873)
    }

    fun getCurrentWeather(lat: Double, lon: Double) = viewModelScope.launch {
        currentWeather.postValue(weatherRepository.getCurrentWeather(lat, lon))
    }

    fun getForecast(lat: Double, lon: Double) = viewModelScope.launch {
        forecast.postValue(weatherRepository.getForecast(lat, lon))
        println("the forecast ${weatherRepository.getForecast(lat, lon)}")
    }

}