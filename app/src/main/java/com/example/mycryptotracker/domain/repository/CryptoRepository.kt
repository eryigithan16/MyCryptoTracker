package com.example.mycryptotracker.domain.repository

import com.example.mycryptotracker.data.remote.dto.CryptoDetailDto
import com.example.mycryptotracker.data.remote.dto.CryptoDto

interface CryptoRepository {
    suspend fun getCryptos(): List<CryptoDto>

    suspend fun getCryptoDetail(id: String) : CryptoDetailDto
}