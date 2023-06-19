package com.ayn.weatherapp.repo

import com.ayn.weatherapp.model.WeatherModel
import com.ayn.weatherapp.service.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface WeatherRepo {
    suspend fun getWeather(id : Int) : WeatherModel
}

class WeatherRepoImpl @Inject constructor(private val service : WeatherService): WeatherRepo {

    override suspend fun getWeather(id : Int): WeatherModel = withContext(Dispatchers.IO){
        service.getWeather(id = id)
    }


}