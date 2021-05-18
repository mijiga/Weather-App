package com.steve.interview.dvt.weather.ui.mainActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.data.repository.WeatherRepository
import com.steve.interview.dvt.weather.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    ViewModel() {

    val currentWeather: MutableLiveData<Resource<CurrentWeather>> = MutableLiveData()
    val forecast: MutableLiveData<Resource<ForecastResponse>> = MutableLiveData()

    init {
        this.getCurrentWeather(-13.9669,33.7873)
        this.getForecast(-13.9669,33.7873)
    }

    fun getCurrentWeather(lat: Double, lon: Double) = viewModelScope.launch {
        val response = weatherRepository.getCurrentWeather(lat, lon)
        currentWeather.postValue(handleCurrentWeatherResponse(response))
    }

    fun getForecast(lat: Double, lon: Double) = viewModelScope.launch {
        val response = weatherRepository.getForecast(lat, lon)
        forecast.postValue(handleForecastResponse(response))
    }

    private fun handleCurrentWeatherResponse(response: Response<CurrentWeather>) : Resource<CurrentWeather>{
        if(response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleForecastResponse(response: Response<ForecastResponse>) : Resource<ForecastResponse> {
        if(response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

}