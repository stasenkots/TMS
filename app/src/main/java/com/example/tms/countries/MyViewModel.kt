package com.example.tms.countries


import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*


class MyViewModel : ViewModel() {
    private val countries = arrayListOf(MinskCountry, BrestCountry, GomelCountry, GrodnoCountry)
    @Volatile var winner=MutableLiveData<Country>()
    fun findWinnerInReapingCrop(){
        for (country in countries) {
           CoroutineScope(Dispatchers.IO).launch {
                country.reapCrop()
            }.invokeOnCompletion {
               if (winner.value==null){
                   winner.postValue(country)
               }
           }
        }

    }
}

