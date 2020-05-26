package id.kotlin.sa_second.presentation

import id.kotlin.sa_second.data.Result

interface HomeViewModelCallback {
    fun onSuccess(res: List<Result>)
    fun onError(err: Throwable)
}