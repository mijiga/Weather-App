package com.steve.interview.dvt.weather.ui.mainActivity

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.steve.interview.dvt.weather.R
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse
import com.steve.interview.dvt.weather.data.repository.FakeLocationRepository
import com.steve.interview.dvt.weather.data.repository.FakeThemeRepository
import com.steve.interview.dvt.weather.data.repository.FakeWeatherRepository
import com.steve.interview.dvt.weather.data.sample.testTheme
import com.steve.interview.dvt.weather.data.sample.testWeatherCode
import com.steve.interview.dvt.weather.util.Constants.Companion.DEFAULT_LAT
import com.steve.interview.dvt.weather.util.Constants.Companion.DEFAULT_LON
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel(FakeWeatherRepository(), FakeThemeRepository(), FakeLocationRepository())
    }

    @Test
    fun `test fetching current weather`() {

        viewModel.getCurrentWeather(DEFAULT_LAT, DEFAULT_LON)
        val value = viewModel.currentWeather.value

        assertThat(value?.data).isInstanceOf(CurrentWeather::class.java)
    }

    @Test
    fun `test fetching forecast`() {
        viewModel.getForecast(DEFAULT_LAT, DEFAULT_LON)
        val value = viewModel.forecast.value
        assertThat(value?.data).isInstanceOf(ForecastResponse::class.java)
    }


    @Test
    fun `test saving theme` () {
        viewModel.saveTheme(testWeatherCode)

        assertThat(viewModel.getTheme()).isEqualTo(testTheme)
    }




}