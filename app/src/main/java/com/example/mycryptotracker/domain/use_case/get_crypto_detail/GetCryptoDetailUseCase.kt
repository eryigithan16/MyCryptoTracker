package com.example.mycryptotracker.domain.use_case.get_crypto_detail

import com.example.mycryptotracker.common.Result
import com.example.mycryptotracker.data.remote.dto.toCryptoDetail
import com.example.mycryptotracker.domain.model.CryptoDetail
import com.example.mycryptotracker.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCryptoDetailUseCase@Inject constructor(private val repository: CryptoRepository) {
    operator fun invoke(id: String) : Flow<Result<CryptoDetail>> = flow {
        try {
            emit(Result.Loading())
            val crypto = repository.getCryptoDetail(id)
            emit(Result.Success(crypto.toCryptoDetail()))
        } catch (e: Exception){
            emit(Result.Error(exception = e))
        }
    }
}