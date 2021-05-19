package com.steve.interview.dvt.weather.data.repository

import androidx.lifecycle.MutableLiveData
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.util.Resource
import okhttp3.ResponseBody
import retrofit2.Response

class FakeWeatherRepository: WeatherRepositoryInt {

    val observableWeatherItems = MutableLiveData<CurrentWeather>()
    val observableForecast = MutableLiveData<ForecastResponse>()

    private var returnNetworkError = false

    override suspend fun getCurrentWeather(lat: Double, lon: Double): Response<CurrentWeather> {
        TODO("Not yet implemented")
    }

    override suspend fun getForecast(lat: Double, lon: Double): Response<ForecastResponse> {
        TODO("Not yet implemented")
    }

    //    override suspend fun getForecast(lat: Double, lon: Double): Response<ForecastResponse> {
//        return if(returnNetworkError){
//            Response.error(401, null)
//        }else{
//            Response.success(ForecastResponse(, 0, "", null, 0))
//        }
//    }


}