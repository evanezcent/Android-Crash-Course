package id.kotlin.sa_mastering.presentation

import id.kotlin.sa_mastering.data.Result

interface HomeView {
    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(res: List<Result>)
    fun onFailure(err: Throwable)
}