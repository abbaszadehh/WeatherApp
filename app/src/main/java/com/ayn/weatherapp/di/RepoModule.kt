package com.ayn.weatherapp.di

import com.ayn.weatherapp.repo.WeatherRepo
import com.ayn.weatherapp.repo.WeatherRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindWeatherRepo(imply: WeatherRepoImpl): WeatherRepo
}