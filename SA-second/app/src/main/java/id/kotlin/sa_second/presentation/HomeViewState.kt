package id.kotlin.sa_second.presentation

import id.kotlin.sa_second.data.Response

sealed class HomeViewState {
    object Loading : HomeViewState()

    data class Success(val response:Response):HomeViewState()
    data class Error(val err: Throwable): HomeViewState()
}