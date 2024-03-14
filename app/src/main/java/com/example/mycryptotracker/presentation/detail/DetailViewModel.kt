package com.example.mycryptotracker.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycryptotracker.common.Result
import com.example.mycryptotracker.domain.model.CryptoDetail
import com.example.mycryptotracker.domain.use_case.get_crypto_detail.GetCryptoDetailUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val getCryptoDetailUseCase: GetCryptoDetailUseCase) : ViewModel() {

    private val _state = mutableStateOf(DetailViewState())
    val state: State<DetailViewState> = _state

    private fun getCrypto(cryptoId: String) {
        getCryptoDetailUseCase(cryptoId).onEach { result ->
            when (result) {
                is Result.Success -> _state.value = state.value.copy(crypto = result.data)
                is Result.Error -> _state.value = state.value.copy(error = result.exception)
                is Result.Loading -> _state.value = state.value.copy(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    /*fun onEvent(event: DetailViewEvent){

    }*/

}

data class DetailViewState(
    val isLoading: Boolean = false,
    val crypto : CryptoDetail? = null,
    val error: Exception? = null
)

sealed class DetailViewEvent{
}