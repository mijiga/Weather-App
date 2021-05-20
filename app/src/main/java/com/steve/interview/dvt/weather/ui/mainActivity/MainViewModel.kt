package com.steve.interview.dvt.weather.ui.mainActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steve.interview.dvt.weather.R
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.data.repository.LocationRepository
import com.steve.interview.dvt.weather.data.repository.ThemeRepository
import com.steve.interview.dvt.weather.data.repository.WeatherRepositoryInt
import com.steve.interview.dvt.weather.util.Constants.Companion.CLEAR_RANGE
import com.steve.interview.dvt.weather.util.Constants.Companion.CLOUDY_RANGE
import com.steve.interview.dvt.weather.util.Constants.Companion.RAINY_RANGE
import com.steve.interview.dvt.weather.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel constructor(
    private val weatherRepository: WeatherRepositoryInt,
    private val themeRepository: ThemeRepository,
    private val defaultLocationRepository: LocationRepository
) :
    ViewModel() {

    val currentWeather: MutableLiveData<Resource<CurrentWeather>> = MutableLiveData()
    val forecast: MutableLiveData<Resource<ForecastResponse>> = MutableLiveData()
    val isDifferentTheme: MutableLiveData<Boolean> = MutableLiveData()


    fun getCurrentWeather(lat: Double, lon: Double) = viewModelScope.launch {
        currentWeather.value = Resource.Loading()
        val response = weatherRepository.getCurrentWeather(lat, lon)
        val resource = handleCurrentWeatherResponse(response)
        currentWeather.postValue(resource)
        resource.data?.let {
            saveTheme(it.weather[0].id)
        }
    }

    fun getForecast(lat: Double, lon: Double) = viewModelScope.launch {
        forecast.value = Resource.Loading()
        val response = weatherRepository.getForecast(lat, lon)
        forecast.postValue(handleForecastResponse(response))
    }

    private fun handleCurrentWeatherResponse(response: Response<CurrentWeather>): Resource<CurrentWeather> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleForecastResponse(response: Response<ForecastResponse>): Resource<ForecastResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    fun getTheme(): Int {
        return themeRepository.getTheme()
    }

    fun saveTheme(weatherCode: Int) {
        val initialTheme = getTheme()

        val theme: Int = when (weatherCode) {
            in CLEAR_RANGE -> {
                R.style.Theme_Sunny
            }
            in CLOUDY_RANGE -> {
                R.style.Theme_Cloudy
            }
            in RAINY_RANGE -> {
                R.style.Theme_Rainy
            }
            else -> {
                R.style.Theme_Sunny
            }
        }

        isDifferentTheme.value = initialTheme != theme

        themeRepository.setTheme(theme)
    }

    fun saveLocation(latitude: Double, longitude: Double) {
        defaultLocationRepository.setLatitude(latitude)
        defaultLocationRepository.setLongitude(longitude)
    }

}