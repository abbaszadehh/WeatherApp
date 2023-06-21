package com.ayn.weatherapp.service

import com.ayn.weatherapp.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {
   @GET("weather")
    suspend fun getWeather(@Query("id") id : Int) : WeatherModel
}