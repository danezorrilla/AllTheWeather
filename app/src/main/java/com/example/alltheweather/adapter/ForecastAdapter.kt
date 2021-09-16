package com.example.alltheweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alltheweather.R
import com.example.alltheweather.model.ForecastResponse

class ForecastAdapter(private val forecastResponse: ForecastResponse):
    RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    class ForecastViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var daysOfWeek: TextView = itemView.findViewById(R.id.day_of_the_week)
        var dayOfWeekWeatherType: ImageView = itemView.findViewById(R.id.weather_type_image)
        var dayOfWeekTemp: TextView = itemView.findViewById(R.id.day_of_the_week_temp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.daily_forecast, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {

        when(forecastResponse.weather.days[position].dayOfTheWeek){
            0 -> {holder.daysOfWeek.text = holder.itemView.context.getString(R.string.sunday)}
            1 -> {holder.daysOfWeek.text = holder.itemView.context.getString(R.string.monday)}
            2 -> {holder.daysOfWeek.text = holder.itemView.context.getString(R.string.tuesday)}
            3 -> {holder.daysOfWeek.text = holder.itemView.context.getString(R.string.wednesday)}
            4 -> {holder.daysOfWeek.text = holder.itemView.context.getString(R.string.thursday)}
            5 -> {holder.daysOfWeek.text = holder.itemView.context.getString(R.string.friday)}
            else -> {holder.daysOfWeek.text = holder.itemView.context.getString(R.string.saturday)}
        }

        when(forecastResponse.weather.days[position].weatherType){
            "sunny" -> {
                holder.dayOfWeekWeatherType.setImageResource(R.drawable.ic_baseline_wb_sunny)
            }
            "cloudy" -> {

                holder.dayOfWeekWeatherType.setImageResource(R.drawable.ic_baseline_cloud)
            }
            "partlyCloudy" -> {
                holder.dayOfWeekWeatherType.setImageResource(R.drawable.partly_sunny)
            }
            "lightRain" -> {
                holder.dayOfWeekWeatherType.setImageResource(R.drawable.light_rain)
            }
            "heavyRain" -> {
                holder.dayOfWeekWeatherType.setImageResource(R.drawable.heavy_rain)
            }
            "snowSleet" -> {
                holder.dayOfWeekWeatherType.setImageResource(R.drawable.ic_baseline_ac_unit)
            }
            else -> {
                holder.dayOfWeekWeatherType.setImageResource(R.drawable.ic_baseline_block)
            }
        }

        holder.dayOfWeekTemp.text = ((forecastResponse.weather.days[position].high +
                forecastResponse.weather.days[position].low) / 2).toString()

    }

    override fun getItemCount(): Int {
        return forecastResponse.weather.days.size
    }


}