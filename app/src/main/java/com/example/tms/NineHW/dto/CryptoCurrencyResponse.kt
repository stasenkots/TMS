package com.example.tms.NineHW.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CryptoCurrencyResponse(
    @Json(name = "data")
    val data: List<Data?>? = null,
    @Json(name = "status")
    val status: Status? = null
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "circulating_supply")
        val circulatingSupply: Double? = null,
        @Json(name = "cmc_rank")
        val cmcRank: Int? = null,
        @Json(name = "date_added")
        val dateAdded: String? = null,
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "last_updated")
        val lastUpdated: String? = null,
        @Json(name = "max_supply")
        val maxSupply: Double? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "num_market_pairs")
        val numMarketPairs: Int? = null,
        @Json(name = "platform")
        val platform: Any? = null,
        @Json(name = "quote")
        val quote: Quote? = null,
        @Json(name = "slug")
        val slug: String? = null,
        @Json(name = "symbol")
        val symbol: String? = null,
        @Json(name = "tags")
        val tags: List<String?>? = null,
        @Json(name = "total_supply")
        val totalSupply: Double? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Quote(
            @Json(name = "BTC")
            val bTC: BTC? = null,
            @Json(name = "USD")
            val uSD: USD? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class BTC(
                @Json(name = "last_updated")
                val lastUpdated: String? = null,
                @Json(name = "market_cap")
                val marketCap: Double? = null,
                @Json(name = "percent_change_1h")
                val percentChange1h: Double? = null,
                @Json(name = "percent_change_24h")
                val percentChange24h: Double? = null,
                @Json(name = "percent_change_7d")
                val percentChange7d: Double? = null,
                @Json(name = "price")
                val price: Double? = null,
                @Json(name = "volume_24h")
                val volume24h: Double? = null
            )

            @JsonClass(generateAdapter = true)
            data class USD(
                @Json(name = "last_updated")
                val lastUpdated: String? = null,
                @Json(name = "market_cap")
                val marketCap: Double? = null,
                @Json(name = "percent_change_1h")
                val percentChange1h: Double? = null,
                @Json(name = "percent_change_24h")
                val percentChange24h: Double? = null,
                @Json(name = "percent_change_7d")
                val percentChange7d: Double? = null,
                @Json(name = "price")
                val price: Double? = null,
                @Json(name = "volume_24h")
                val volume24h: Double? = null
            )
        }
    }

    @JsonClass(generateAdapter = true)
    data class Status(
        @Json(name = "credit_count")
        val creditCount: Int? = null,
        @Json(name = "elapsed")
        val elapsed: Int? = null,
        @Json(name = "error_code")
        val errorCode: Int? = null,
        @Json(name = "error_message")
        val errorMessage: String? = null,
        @Json(name = "timestamp")
        val timestamp: String? = null
    )
}