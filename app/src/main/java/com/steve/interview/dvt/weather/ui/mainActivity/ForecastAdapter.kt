package com.steve.interview.dvt.weather.ui.mainActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.steve.interview.dvt.weather.R
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.util.Constants
import kotlin.collections.ArrayList

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private lateinit var context:Context
    var list: List<CurrentWeather> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val mInflater = LayoutInflater.from(parent.context)
        val view = mInflater.inflate(R.layout.forecast_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val forecastItem = list[position]

        holder.tempView.text = forecastItem.main.temp.toString()
        holder.dayView.text = forecastItem.weather[0].main

        holder.iconView.setImageResource(getIcon(forecastItem.weather[0].id))

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dayView: TextView = itemView.findViewById(R.id.day)
        var tempView: TextView = itemView.findViewById(R.id.temp)
        var iconView: ImageView = itemView.findViewById(R.id.imageView3)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun getIcon(weatherCode: Int): Int {

        return when (weatherCode) {
            in Constants.CLEAR_RANGE -> {
                R.drawable.clear
            }
            in Constants.CLOUDY_RANGE -> {
                R.drawable.cloudy
            }
            in Constants.RAINY_RANGE -> {
                R.drawable.rain
            }
            else -> {
                R.drawable.clear
            }
        }
    }

}