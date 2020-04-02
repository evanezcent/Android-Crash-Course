package id.kotlin.sa_mastering.presentation

import id.kotlin.sa_mastering.data.Result

interface HomeViewModelCallback {
    fun onSuccess(res: List<Result>)
    fun onFailed(err: Throwable)
}