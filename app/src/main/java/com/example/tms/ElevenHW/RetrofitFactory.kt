package com.example.tms.ElevenHW

import retrofit2.Retrofit
import retrofit2.create


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL="https://api.openweathermap.org"
object RetrofitFactory {

    private val interceptor=HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BODY
    }
    private val client=OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .readTimeout(5,TimeUnit.SECONDS)
        .connectTimeout(5,TimeUnit.SECONDS)
        .build()
    fun getRetrofit():WeatherAPI=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
            .create()
}