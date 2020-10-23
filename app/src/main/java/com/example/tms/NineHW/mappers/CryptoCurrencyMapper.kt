package com.example.tms.NineHW.mappers

import com.example.tms.NineHW.dto.CryptoCurrencyResponse
import com.example.tms.NineHW.entity.CryptoCurrency

fun map(response: CryptoCurrencyResponse.Data?): CryptoCurrency {
    return CryptoCurrency(
        id =  response?.id?:0,
        name = response?.name.orEmpty(),
        percentChange = response?.quote?.uSD?.percentChange24h?:0.0,
        price= response?.quote?.uSD?.price?:0.0
        )
}
