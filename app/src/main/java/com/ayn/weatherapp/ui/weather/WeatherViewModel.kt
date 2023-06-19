package com.ayn.weatherapp.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayn.weatherapp.model.WeatherModel
import com.ayn.weatherapp.repo.WeatherRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repo: WeatherRepo) : ViewModel() {

   private val _data = MutableLiveData<WeatherModel>()
    val data: LiveData<WeatherModel>
        get() = _data

    fun getWeather(id: Int) {
        viewModelScope.launch {
            try {
                _data.value = repo.getWeather(id)
            } catch (e: java.lang.Exception){
                e.printStackTrace()
            }

        }

    }
}