package com.example.tms.FourteenHW.dto


import com.google.gson.annotations.SerializedName

data class SummaryResponse(
    @SerializedName("Countries")
    val countries: List<CountryResponse?>?,
    @SerializedName("Date")
    val date: String?,
    @SerializedName("Global")
    val global: GlobalResponse?,
    @SerializedName("Message")
    val message: String?
)

data class CountryResponse(
    var flagUrl: String? = null,
    @SerializedName("Country")
    val country: String?,
    @SerializedName("CountryCode")
    val countryCode: String?,
    @SerializedName("Date")
    val date: String?,
    @SerializedName("NewConfirmed")
    val newConfirmed: Int?,
    @SerializedName("NewDeaths")
    val newDeaths: Int?,
    @SerializedName("NewRecovered")
    val newRecovered: Int?,
    @SerializedName("Slug")
    val slug: String?,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int?,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int?,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int?
)

data class GlobalResponse(
    @SerializedName("NewConfirmed")
    val newConfirmed: Int?,
    @SerializedName("NewDeaths")
    val newDeaths: Int?,
    @SerializedName("NewRecovered")
    val newRecovered: Int?,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int?,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int?,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int?
)
