package com.example.mycryptotracker.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycryptotracker.common.Result
import com.example.mycryptotracker.domain.model.Crypto
import com.example.mycryptotracker.domain.use_case.get_cryptos.GetCryptosUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val getCryptosUseCase: GetCryptosUseCase) : ViewModel() {

    private val _state = mutableStateOf(HomeViewState())
    val state: State<HomeViewState> = _state

    init {
        getCryptos()
    }

    private fun getCryptos() {
        getCryptosUseCase().onEach { result ->
            when (result) {
                is Result.Success -> _state.value = state.value.copy(cryptos = result.data ?: emptyList())
                is Result.Error -> _state.value = state.value.copy(error = result.exception)
                is Result.Loading -> _state.value = state.value.copy(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeViewEvent){
        when(event){
            is HomeViewEvent.SearchCrypto -> {
                Log.e("@@@","Search yapılacak DB'den")
            }
        }
    }

}

data class HomeViewState(
    val isLoading: Boolean = false,
    val cryptos : List<Crypto> = emptyList(),
    val error: Exception? = null
)

sealed class HomeViewEvent{
    data class SearchCrypto(val searchString: String): HomeViewEvent()
}