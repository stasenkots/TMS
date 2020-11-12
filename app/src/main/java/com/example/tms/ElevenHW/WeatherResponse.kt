package com.example.tms.ElevenHW


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("main")
    val main: Main? = null,
    @SerializedName("sys")
    val sys: Sys? = null,
    @SerializedName("weather")
    val weather: List<Weather?>? = null

) {


    data class Main(
        @SerializedName("feels_like")
        val feelsLike: Double? = null,
        @SerializedName("temp")
        val temp: Double? = null
    )

    data class Sys(
        @SerializedName("country")
        val country: String? = null
    )

    data class Weather(
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("icon")
        val icon: String? = null
    )

}