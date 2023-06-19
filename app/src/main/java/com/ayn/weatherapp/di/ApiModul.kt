package com.ayn.weatherapp.di

import com.ayn.weatherapp.BuildConfig
import com.ayn.weatherapp.Const.APIURL
import com.ayn.weatherapp.model.WeatherModel
import com.ayn.weatherapp.service.WeatherService
import com.google.gson.Gson
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class ApiModul {

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        val okHttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG)
            okHttpBuilder.addInterceptor(OkHttpProfilerInterceptor())
        return okHttpBuilder
    }

    @Singleton
    @Provides
    fun createRetrofit(okHttpBuilder : OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder().baseUrl(APIURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpBuilder.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService = retrofit.create()

}