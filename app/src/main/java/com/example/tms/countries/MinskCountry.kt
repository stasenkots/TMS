package com.example.tms.countries
import android.util.Log
import androidx.lifecycle.MutableLiveData

import kotlinx.coroutines.delay
import kotlin.random.Random

object MinskCountry : Country {
    override val name="MinskCountry"
    override var potato= MutableLiveData(0)
    override var cabbage= MutableLiveData(0)
    override var beet= MutableLiveData(0)
}