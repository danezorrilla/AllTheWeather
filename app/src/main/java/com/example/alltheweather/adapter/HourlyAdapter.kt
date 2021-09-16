package com.example.alltheweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alltheweather.R
import com.example.alltheweather.model.ForecastResponse

class HourlyAdapter(private val forecastResponse: ForecastResponse):
    RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder>(){

    class HourlyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var hourlyWeatherType: ImageView? = itemView.findViewById(R.id.hourly_weather_type_image)
        var timeTV: TextView = itemView.findViewById(R.id.time_textview)
        var tempTV: TextView = itemView.findViewById(R.id.temp_textview)
        var chanceOfRain: TextView = itemView.findViewById(R.id.chance_of_rain_textview)
        var windTV: TextView = itemView.findViewById(R.id.wind_textview)
        var humidity: TextView = itemView.findViewById(R.id.humidity_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hourly_forecast, parent, false)
        return HourlyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {

        when(forecastResponse.weather.days[position].hourlyWeather[position].weatherType){
            "sunny" -> {
                holder.hourlyWeatherType?.setImageResource(R.drawable.ic_baseline_wb_sunny)
            }
            "cloudy" -> {
                holder.hourlyWeatherType?.setImageResource(R.drawable.ic_baseline_cloud)
            }
            "partlyCloudy" -> {
                holder.hourlyWeatherType?.setImageResource(R.drawable.partly_sunny)
            }
            "lightRain" -> {
                holder.hourlyWeatherType?.setImageResource(R.drawable.light_rain)
            }
            "heavyRain" -> {
                holder.hourlyWeatherType?.setImageResource(R.drawable.heavy_rain)
            }
            "snowSleet" -> {
                holder.hourlyWeatherType?.setImageResource(R.drawable.ic_baseline_ac_unit)
            }
            "else" -> {
                holder.hourlyWeatherType?.setImageResource(R.drawable.ic_baseline_block)
            }
        }

        when(forecastResponse.weather.days[position].hourlyWeather[position].hour){
            0 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.midnight)}
            1 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.one_am)}
            2 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.two_am)}
            3 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.three_am)}
            4 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.four_am)}
            5 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.five_am)}
            6 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.six_am)}
            7 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.seven_am)}
            8 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.eight_am)}
            9 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.nine_am)}
            10 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.ten_am)}
            11 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.eleven_am)}
            12 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.noon)}
            13 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.one_pm)}
            14 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.two_pm)}
            15 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.three_pm)}
            16 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.four_pm)}
            17 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.five_pm)}
            18 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.six_pm)}
            19 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.seven_pm)}
            20 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.eight_pm)}
            21 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.nine_pm)}
            22 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.ten_pm)}
            23 -> {holder.timeTV.text = holder.itemView.context.getString(R.string.eleven_pm)}
        }

        holder.tempTV.text = forecastResponse.weather.days[position].hourlyWeather[position]
            .temperature.toString()

        holder.chanceOfRain.text = ((forecastResponse.weather.days[position].hourlyWeather[position]
            .rainChance * 100).toString() + "%")

        holder.windTV.text = forecastResponse.weather.days[position].hourlyWeather[position]
            .windSpeed.toString()

        holder.humidity.text = ((forecastResponse.weather.days[position].hourlyWeather[position]
            .humidity * 100).toString() + "%")

    }

    override fun getItemCount(): Int {
        return forecastResponse.weather.days.size
    }

}