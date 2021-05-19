package com.steve.interview.dvt.weather.ui.mainActivity

import android.content.SharedPreferences
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
import com.steve.interview.dvt.weather.data.repository.ThemeRepository
import com.steve.interview.dvt.weather.data.repository.WeatherRepository
import com.steve.interview.dvt.weather.databinding.ActivityMainBinding
import com.steve.interview.dvt.weather.util.Constants
import com.steve.interview.dvt.weather.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var retrofit: WeatherAPI
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ForecastAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel(WeatherRepository(retrofit), ThemeRepository(sharedPreferences))
        setTheme(viewModel.getTheme())

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = ForecastAdapter()
        binding.forecastRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.forecastRecyclerView.adapter = adapter

        viewModel.currentWeather.observe(this, {
            setupViews(it)
        })

        viewModel.forecast.observe(this, {
            setupRecyclerView(it)
        })

        viewModel.isDifferentTheme.observe(this, {
            //observes value change and if its true it recreates the activity in order to change the theme.
            if(it){
                recreate()
            }
        })

    }

    private fun setupRecyclerView(resource: Resource<ForecastResponse>){
        when(resource){
            is Resource.Success -> {
                resource.data?.let {
                    adapter.list = it.list
                    adapter.notifyDataSetChanged()
                }
            }
            is Resource.Error -> {
                Toast.makeText(this, getString(R.string.forecast_error_text), LENGTH_SHORT).show()
            }
            is Resource.Loading -> {
                Log.i(TAG, getString(R.string.loading))
            }
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
                    setupImage(it.weather[0].id)
                }
            }
            is Resource.Error -> {
                Toast.makeText(this, getString(R.string.weather_error_text), LENGTH_SHORT).show()
                resource.message?.let {
                    Log.e(TAG, it)
                }
            }
            is Resource.Loading -> {
                binding.currentState.text = getString(R.string.loading)
            }
        }
    }

    private fun setupImage(weatherCode: Int){

        val image: Int = when (weatherCode) {
            in Constants.CLEAR_RANGE -> {
                R.drawable.forest_sunny
            }
            in Constants.CLOUDY_RANGE -> {
                R.drawable.forest_cloudy
            }
            in Constants.RAINY_RANGE -> {
                R.drawable.forest_rainy
            }
            else -> {
                R.drawable.forest_sunny
            }
        }

        binding.imageView.setImageResource(image)
    }

    private fun doubleToTemp(temp: Double): String {
        return "$temp"
    }
}