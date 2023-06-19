package com.ayn.weatherapp.model

import java.io.Serializable

data class WeatherModel(

    val base: String?,
    val visibility: String?,
    val weather: List<Weather?>?,
    val main: Main?,
    val dt: Double?,
    val timezone: Double?,
    val id: Int?,
    val name: String?,
    val cod: String?
) : Serializable

data class Weather(val id: Int?, val main: String?, val description: String?, val icon: String?)

data class Main(
    val temp: Double?, val pressure: Double?,
    val humidity: Double?, val temp_min: Double?,
    val temp_max: Double?, val feels_like: Double
)