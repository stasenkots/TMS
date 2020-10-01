package com.example.tms.FiveHW
import androidx.collection.arraySetOf

val coffeeCollection= arraySetOf<Coffee>()

data class Coffee(val name:String, val price:Double, val imageURL:String)