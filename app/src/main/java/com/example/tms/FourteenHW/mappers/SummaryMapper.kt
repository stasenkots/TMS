package com.example.tms.FourteenHW.mappers

import com.example.tms.FourteenHW.dto.CountryResponse
import com.example.tms.FourteenHW.entity.Country

object SummaryMapper {

    fun map(from: CountryResponse): Country {

        return Country(
            country = from.country.orEmpty(),
            countryCode = from.countryCode.orEmpty(),
            date = from.date?.substringBefore("T").orEmpty(),
            totalConfirmed = from.totalConfirmed ?: 0,
            totalDeaths = from.totalDeaths ?: 0,
            totalRecovered = from.totalRecovered ?: 0,
            flagUrl = from.flagUrl.orEmpty()
        )
    }
}