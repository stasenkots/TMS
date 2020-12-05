package com.example.tms.FourteenHW

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms.FourteenHW.entity.Country
import com.example.tms.FourteenHW.mappers.SummaryMapper
import com.example.tms.FourteenHW.retrofit.RetrofitFactory

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CovidViewModel:ViewModel() {
    val listCountries= MutableLiveData<List<Country?>>()
     val compositeDisposable= CompositeDisposable()
    fun getListCounties(){

        val api = RetrofitFactory().provideApi()

        val summaryDisposable = api.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { summaryResponse ->
                summaryResponse.countries?.map {
                    it?.flagUrl =
                        "https://www.countryflags.io/${it?.countryCode}/flat/64.png"
                    it
                }
            }
            .subscribe({ listOfResponsePlusUrl ->

                listCountries.postValue( listOfResponsePlusUrl?.map { response ->
                    response?.let { SummaryMapper.map(it) }
                }?: listOf())


            }, {
                Log.e("AAA", it.localizedMessage)
            })

        compositeDisposable.add(summaryDisposable)
    }
}