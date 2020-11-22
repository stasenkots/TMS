package com.example.tms.ElevenHW

object Mapper {
    fun weatherResponseToWeather(response: WeatherResponse)=
        with(response) {
            Weather(
                null,
                sys?.country?:"Undefined",
                main?.temp?.toInt()?:0,
                "https://openweathermap.org/img/wn/${weather?.get(0)?.icon ?:""}@2x.png",
                weather?.get(0)?.description?:""
            )
        }
}