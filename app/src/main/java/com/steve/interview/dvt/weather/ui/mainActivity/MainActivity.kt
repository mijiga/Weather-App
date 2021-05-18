package com.steve.interview.dvt.weather.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.steve.interview.dvt.weather.R
import com.steve.interview.dvt.weather.api.WeatherAPI
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.data.repository.WeatherRepository
import com.steve.interview.dvt.weather.databinding.ActivityMainBinding
import com.steve.interview.dvt.weather.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var retrofit: WeatherAPI
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ForecastAdapter //TODO: revisit having this as a global val

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: The image is being cropped at the bottom
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = ForecastAdapter()
        binding.forecastRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.forecastRecyclerView.adapter = adapter

        val viewModel = MainViewModel(WeatherRepository(retrofit))
        viewModel.currentWeather.observe(this, {
            setupViews(it)
        })

        viewModel.forecast.observe(this, {
            setupRecycler(it)
        })

    }

    private fun setupRecycler(resource: Resource<ForecastResponse>){
        when(resource){
            is Resource.Success -> {
                resource.data?.let {
                    adapter.list = it.list
                    adapter.notifyDataSetChanged()
                }
            }
            is Resource.Error -> {
                Toast.makeText(this, "Couldn't get forecast", LENGTH_SHORT).show()
            }
            is Resource.Loading -> TODO()
        }
    }

    private fun setupViews(resource: Resource<CurrentWeather>){
        when(resource){
            is Resource.Success -> {
                resource.data?.let {
                    binding.mainTemperature.text = doubleToTemp(it.main.temp)
                    binding.currentTemperature.text = doubleToTemp(it.main.temp)
                    binding.minTemperature.text = doubleToTemp(it.main.temp_min)
                    binding.maxTemperature.text = doubleToTemp(it.main.temp_max)
                    binding.currentState.text = it.weather[0].main
                }
            }
            is Resource.Error -> {
                Toast.makeText(this, "Couldn't get Current Weather", LENGTH_SHORT).show()
                resource.message?.let {
                    Log.e(TAG, it)
                }
            }
            is Resource.Loading -> TODO()
        }
    }

    private fun doubleToTemp(temp: Double): String {//TODO: This doesn't belong in this class
        return "$temp"
    }
}