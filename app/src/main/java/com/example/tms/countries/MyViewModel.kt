package com.example.tms.countries


import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*


class MyViewModel : ViewModel() {
    val countries = mapOf(
        "MinskCountry" to Country("MinskCountry"),
        "GomelCountry" to Country("GomelCountry"),
        "GrodnoCountry" to Country("GrodnoCountry"),
        "BrestCountry" to Country("BrestCountry")
    )
    @Volatile
    var winner = MutableLiveData<Country>()

    @InternalCoroutinesApi
    fun findWinnerInReapingCrop() {
        for (country in countries.values) {
            CoroutineScope(Dispatchers.IO).launch {
                country.reapCrop()
            }.invokeOnCompletion {
                kotlinx.coroutines.internal.synchronized(this) {
                    if (winner.value == null) {
                        winner.postValue(country)
                    }
                }
            }
        }
    }
}

