package com.example.mycryptotracker.data.repository

import com.example.mycryptotracker.data.remote.CryptoCurrencyApi
import com.example.mycryptotracker.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val api: CryptoCurrencyApi ): CryptoRepository {
    override suspend fun getCryptos() = api.getCoins()
    override suspend fun getCryptoDetail(id: String) = api.getCoin(id)
}