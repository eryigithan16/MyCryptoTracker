package com.example.mycryptotracker.domain.model

import com.example.mycryptotracker.data.remote.dto.Description
import com.example.mycryptotracker.data.remote.dto.Image

data class CryptoDetail(
    val id: String,
    val image: Image,
    val description: Description,
    val lastUpdated: String,
    val price: Int,
    val priceChangePercentageIn24h: Int
)
