package id.kotlin.sa_second

interface HomeView {
    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(res: List<Result>)
    fun onFailure(err: Throwable)
}