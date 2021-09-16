package com.example.alltheweather.network

import com.example.alltheweather.model.ForecastResponse
import com.example.alltheweather.model.Weather
import com.example.alltheweather.model.WeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRetrofit {

    fun getLocationList(): Call<WeatherResponse>{
        return Retrofit.Builder()
            .baseUrl("https://weather.exam.bottlerocketservices.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
            .getCityList()
    }

    fun getLocationForecast(cityID: Int): Call<ForecastResponse>{
        return Retrofit.Builder()
            .baseUrl("https://weather.exam.bottlerocketservices.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
            .getCityForecast(cityID)
    }
}