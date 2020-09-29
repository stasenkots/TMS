package com.example.tms.countries

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlin.random.Random


class Country(val name: String) {
    var potato = MutableLiveData(0)
    var cabbage = MutableLiveData(0)
    var beet = MutableLiveData(0)
    suspend fun reapCrop() {
        while (potato.value?.plus(cabbage.value ?: 0)?.plus(beet.value ?: 0) ?: 0 < 100) {
            potato.postValue(potato.value?.plus(Random.Default.nextInt(10)))
            cabbage.postValue(cabbage.value?.plus(Random.Default.nextInt(10)))
            beet.postValue(beet.value?.plus(Random.Default.nextInt(10)))
            delay((Random.Default.nextInt()%2000).toLong())
        }

    }
}




