package id.kotlin.sa_second.presentation

import id.kotlin.sa_second.data.Result

interface HomeView {
    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(res: List<Result>)
    fun onFailure(err: Throwable)
}