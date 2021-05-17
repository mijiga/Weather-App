package com.steve.interview.dvt.weather.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.steve.interview.dvt.weather.R
import com.steve.interview.dvt.weather.api.WeatherAPI
import com.steve.interview.dvt.weather.data.repository.WeatherRepository
import com.steve.interview.dvt.weather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: WeatherAPI
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: The image is being cropped at the bottom
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val adapter = ForecastAdapter()
        binding.forecastRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.forecastRecyclerView.adapter = adapter


        val viewModel = MainViewModel(WeatherRepository(retrofit))
        viewModel.currentWeather.observe(this, {

            Toast.makeText(this,"max ${it.main.temp_max}", LENGTH_SHORT).show()
            binding.mainTemperature.text = doubleToTemp(it.main.temp)
            binding.currentTemperature.text = doubleToTemp(it.main.temp)
            binding.minTemperature.text = doubleToTemp(it.main.temp_min)
            binding.maxTemperature.text = doubleToTemp(it.main.temp_max)
            binding.currentState.text = it.weather[0].main

        })

        viewModel.forecast.observe(this, {
            adapter.list = it.list
            adapter.notifyDataSetChanged()
        })

    }

    private fun doubleToTemp(temp: Double): String {//TODO: This doesn't belong in this class
        return "$temp"
    }
}