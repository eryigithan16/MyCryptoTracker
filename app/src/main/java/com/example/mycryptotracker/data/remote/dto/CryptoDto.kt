package com.example.mycryptotracker.data.remote.dto

import com.example.mycryptotracker.domain.model.Crypto

data class CryptoDto(
    val id: String,
    val name: String,
    val symbol: String
)

fun CryptoDto.toCrypto(): Crypto {
    return Crypto(id, name)
}