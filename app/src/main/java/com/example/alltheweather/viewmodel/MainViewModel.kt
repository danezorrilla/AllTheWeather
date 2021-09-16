package com.example.alltheweather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alltheweather.model.ForecastResponse
import com.example.alltheweather.model.WeatherResponse
import com.example.alltheweather.network.WeatherRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private var weatherRetrofit: WeatherRetrofit = WeatherRetrofit()
    private var weatherMutableLiveData = MutableLiveData<WeatherResponse>()
    private var forecastMutableLiveData = MutableLiveData<ForecastResponse>()

    fun getLocationListResponse(): MutableLiveData<WeatherResponse> {
        weatherRetrofit.getLocationList().enqueue(object : Callback<WeatherResponse>{
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful && response.body() != null)
                    weatherMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            }
        })

        return weatherMutableLiveData
    }

    fun getLocationForecastResponse(cityID: Int): MutableLiveData<ForecastResponse>{
        weatherRetrofit.getLocationForecast(cityID).enqueue(object : Callback<ForecastResponse>{
            override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                if(response.isSuccessful && response.body() != null)
                    forecastMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
            }

        })

        return forecastMutableLiveData
    }

}