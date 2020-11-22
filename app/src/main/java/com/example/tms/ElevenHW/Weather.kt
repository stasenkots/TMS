package com.example.tms.ElevenHW

data class Weather(
    var city:String?,
    val country:String,
    val temperature:Int,
    val icon:String,
    val description:String
)