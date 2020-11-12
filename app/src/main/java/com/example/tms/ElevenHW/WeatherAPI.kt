package com.example.tms.ElevenHW

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("/data/2.5/weather")
    fun getWeatherAPIAsync(
        @Query("q")
        cityName:String,
        @Query("appid")
        appID:String,
        @Query("units")
        units:String="metric"
    ): Deferred<Response<WeatherResponse>>
}