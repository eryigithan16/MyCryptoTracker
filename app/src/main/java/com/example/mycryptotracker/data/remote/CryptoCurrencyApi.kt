package com.example.mycryptotracker.data.remote

import com.example.mycryptotracker.data.remote.dto.CryptoDetailDto
import com.example.mycryptotracker.data.remote.dto.CryptoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoCurrencyApi {

    @GET("/coins/list")
    suspend fun getCoins(): List<CryptoDto>

    @GET("/coins/{id]")
    suspend fun getCoin(
        @Path("id") coinId: String,
        @Query("localization") localization: Boolean = false,
        @Query("tickers") tickers: Boolean = false,
        @Query("market_data") marketData: Boolean = true,
        @Query("community_data") communityData: Boolean = false,
        @Query("developer_data") developerData: Boolean = false,
        @Query("sparkline") sparkline: Boolean = false,
    ): CryptoDetailDto
}