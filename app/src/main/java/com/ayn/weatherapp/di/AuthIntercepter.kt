package com.ayn.weatherapp.di

import com.ayn.weatherapp.Const.APIURL
import okhttp3.Interceptor
import okhttp3.Response

class AuthIntercepter : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val newParams = request.url().newBuilder()
            .addQueryParameter("appid",APIURL)
            .addQueryParameter("units","metric") //For temperature in Celsius
            .build()
        request = request.newBuilder().url(newParams).build()
        return chain.proceed(request)
    }
}