package com.example.tms.ElevenHW

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val APP_ID = "066684c224288ec83f079c8017eb1057"
const val UNITS="metric"
interface WeatherAPI {
    @GET("/data/2.5/weather")
    fun getWeatherAPIAsync(
        @Query("q")
        cityName:String,
        @Query("appid")
        appID:String= APP_ID,
        @Query("units")
        units:String= UNITS
    ): Deferred<Response<WeatherResponse>>
}