package com.example.mycryptotracker.domain.use_case.get_cryptos

import com.example.mycryptotracker.common.Result
import com.example.mycryptotracker.data.remote.dto.toCrypto
import com.example.mycryptotracker.domain.model.Crypto
import com.example.mycryptotracker.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCryptosUseCase @Inject constructor(private val repository: CryptoRepository) {

    operator fun invoke() : Flow<Result<List<Crypto>>> = flow {
        try {
            emit(Result.Loading())
            val cryptoList = repository.getCryptos()
            emit(Result.Success(cryptoList.map { it.toCrypto() }))
        } catch (e: Exception){
            emit(Result.Error(exception = e))
        }
    }

}