package com.example.tms.countries

import androidx.lifecycle.MutableLiveData


object BrestCountry : Country {
    override val name="BrestCountry"
    override var potato= MutableLiveData(0)
    override var cabbage= MutableLiveData(0)
    override var beet= MutableLiveData(0)



}