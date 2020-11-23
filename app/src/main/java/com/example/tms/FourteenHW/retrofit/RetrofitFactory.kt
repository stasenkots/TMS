package com.example.tms.FourteenHW.retrofit

import com.example.tms.FourteenHW.networking.CovidApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL="https://api.covid19api.com/"

class RetrofitFactory {
    private val interceptor=HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BODY
    }
   private val client = OkHttpClient.Builder()
       .addInterceptor(interceptor)
       .build()


    fun provideApi(): CovidApi {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create()
    }
}