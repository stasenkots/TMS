package com.example.tms.countries

import androidx.lifecycle.MutableLiveData

object GrodnoCountry : Country {
    override val name="GrodnoCountry"
    override var potato= MutableLiveData(0)
    override var cabbage= MutableLiveData(0)
    override var beet= MutableLiveData(0)
}