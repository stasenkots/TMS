package com.example.tms.FourteenHW.networking

import com.example.tms.FourteenHW.dto.SummaryResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CovidApi {

    @GET("summary")
    fun getAll(): Single<SummaryResponse>
}