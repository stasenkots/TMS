package com.example.tms.countries

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlin.random.Random



interface Country{
    var potato:MutableLiveData<Int>
    var cabbage:MutableLiveData<Int>
    var beet:MutableLiveData<Int>
    val name:String

    suspend fun reapCrop() {
        while (potato.value?.plus(cabbage.value ?:0)?.plus(beet.value?:0)?:0 < 100){
        potato.postValue( potato.value?.plus(Random.Default.nextInt(10)))
        cabbage.postValue(cabbage.value?.plus(Random.Default.nextInt(10)))
        beet.postValue(beet.value?.plus(Random.Default.nextInt(10)))
        delay(1000)
    }
    }


}

