package com.steve.interview.dvt.weather.ui.mainActivity

import android.Manifest
import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.steve.interview.dvt.weather.R
import com.steve.interview.dvt.weather.api.WeatherAPI
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.data.repository.DefaultLocationRepository
import com.steve.interview.dvt.weather.data.repository.DefaultThemeRepository
import com.steve.interview.dvt.weather.data.repository.WeatherRepository
import com.steve.interview.dvt.weather.databinding.ActivityMainBinding
import com.steve.interview.dvt.weather.util.Constants
import com.steve.interview.dvt.weather.util.Constants.Companion.REQUEST_CODE_LOCATION_PERMISSION
import com.steve.interview.dvt.weather.util.PermissionUtility
import com.steve.interview.dvt.weather.util.Resource
import com.steve.interview.dvt.weather.util.toTemperature
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    
    private val TAG = "MainActivity"

    @Inject
    lateinit var retrofit: WeatherAPI

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ForecastAdapter

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var viewModel: MainViewModel
    lateinit var defaultLocationRepository: DefaultLocationRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = MainViewModel(
            WeatherRepository(retrofit),
            DefaultThemeRepository(sharedPreferences),
            DefaultLocationRepository(sharedPreferences)
        )
        setTheme(viewModel.getTheme())
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        requestPermissions()

        defaultLocationRepository = DefaultLocationRepository(sharedPreferences)

        adapter = ForecastAdapter()
        binding.forecastRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.forecastRecyclerView.adapter = adapter

        viewModel.currentWeather.observe(
            this,
            {
                setupViews(it)
            }
        )

        viewModel.forecast.observe(
            this,
            {
                setupRecyclerView(it)
            }
        )

        viewModel.isDifferentTheme.observe(
            this,
            {
                // observes value change and if its true it recreates the activity in order to change the theme.
                if (it) {
                    recreate()
                }
            }
        )
    }

    private fun setupRecyclerView(resource: Resource<ForecastResponse>) {
        when (resource) {
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

    private fun setupViews(resource: Resource<CurrentWeather>) {
        when (resource) {
            is Resource.Success -> {
                resource.data?.let {
                    binding.mainTemperature.text = it.main.temp.toTemperature()
                    binding.currentTemperature.text = it.main.temp.toTemperature()
                    binding.minTemperature.text = it.main.temp_min.toTemperature()
                    binding.maxTemperature.text = it.main.temp_max.toTemperature()
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

    private fun setupImage(weatherCode: Int) {

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

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    viewModel.getForecast(location.latitude, location.longitude)
                    viewModel.getCurrentWeather(location.latitude, location.longitude)
                    viewModel.saveLocation(location.latitude, location.longitude)
                } else {
                    viewModel.getForecast(
                        defaultLocationRepository.getLatitude(),
                        defaultLocationRepository.getLongitude()
                    )
                    viewModel.getCurrentWeather(
                        defaultLocationRepository.getLatitude(),
                        defaultLocationRepository.getLongitude()
                    )
                }
            }
    }

    private fun requestPermissions() {
        if (PermissionUtility.hasLocationPermissions(this)) {
            getLocation()
        }

        EasyPermissions.requestPermissions(
            this,
            getString(R.string.location_permission_rationale),
            REQUEST_CODE_LOCATION_PERMISSION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
        )
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        getLocation()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            requestPermissions()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}
