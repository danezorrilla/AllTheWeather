package com.example.alltheweather.network

import com.example.alltheweather.model.ForecastResponse
import com.example.alltheweather.model.Weather
import com.example.alltheweather.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherAPI {

    // https://weather.exam.bottlerocketservices.com/cities

    @GET("/cities")
    fun getCityList(): Call<WeatherResponse>

    @GET("/cities/{cityID}")
    fun getCityForecast(@Path("cityID")cityID: Int): Call<ForecastResponse>
}