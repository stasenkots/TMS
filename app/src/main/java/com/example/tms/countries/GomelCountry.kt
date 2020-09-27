package com.example.tms.countries

import androidx.lifecycle.MutableLiveData

object GomelCountry : Country {
    override val name="GomelCountry"
    override var potato= MutableLiveData(0)
    override var cabbage= MutableLiveData(0)
    override var beet= MutableLiveData(0)
}