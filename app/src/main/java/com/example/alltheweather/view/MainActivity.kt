package com.example.alltheweather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alltheweather.R
import com.example.alltheweather.adapter.ForecastAdapter
import com.example.alltheweather.adapter.HourlyAdapter
import com.example.alltheweather.model.ForecastResponse
import com.example.alltheweather.model.WeatherResponse
import com.example.alltheweather.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainObserver: Observer<WeatherResponse>
    private lateinit var forecastObserver: Observer<ForecastResponse>
    private lateinit var arrayAdapter: ArrayAdapter<*>

    private var cityName: String? = null
    private  var cityID: Int? = null

    private val cityMap = mutableMapOf<String, Int>()
    private val cityNameList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainObserver = Observer { weatherResponse -> displayLocationList(weatherResponse) }
        mainViewModel.getLocationListResponse().observe(this, mainObserver)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cityNameList)
        autoCompleteTextView.setAdapter(arrayAdapter)

        submit_city_name.setOnClickListener {
            cityName = autoCompleteTextView.text.toString()
            cityID = cityMap[cityName]

            forecastObserver = Observer { forecastResponse ->
                displayLocationForecast(forecastResponse) }

            cityID?.let { it ->
                mainViewModel.getLocationForecastResponse(it)
                    .observe(this, forecastObserver) }
        }

    }

    private fun displayLocationList(weatherResponse: WeatherResponse){
        for(i in weatherResponse.cities.indices){
            cityMap[weatherResponse.cities[i].name] = weatherResponse.cities[i].geonameid
            cityNameList.add(weatherResponse.cities[i].name)
        }
    }

    private fun displayLocationForecast(forecastResponse: ForecastResponse){
        for (i in forecastResponse.weather.days.indices){

            daily_city_forecast.layoutManager = LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false)
            daily_city_forecast.adapter = ForecastAdapter(forecastResponse)

            hourly_city_forecast.layoutManager = LinearLayoutManager(this)
            hourly_city_forecast.adapter = HourlyAdapter(forecastResponse)
        }
    }

}