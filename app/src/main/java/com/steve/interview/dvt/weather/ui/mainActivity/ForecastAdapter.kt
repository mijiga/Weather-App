package com.steve.interview.dvt.weather.ui.mainActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.steve.interview.dvt.weather.R
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import java.text.SimpleDateFormat
import java.util.*
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
        val weather = list[position]

        holder.tempView.text = weather.main.temp.toString()//TODO: Need the degree symbol

        holder.dayView.text = weather.getDay()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dayView: TextView = itemView.findViewById(R.id.day)
        var tempView: TextView = itemView.findViewById(R.id.temp)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}