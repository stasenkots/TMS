package com.example.tms.NineHW.network

import com.example.tms.NineHW.dto.CryptoCurrencyResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CoinMarketCapAPI {
    @GET("v1/cryptocurrency/listings/latest")
    fun getCryptoCurrenciesAsync(
    ): Deferred<Response<CryptoCurrencyResponse>>
}