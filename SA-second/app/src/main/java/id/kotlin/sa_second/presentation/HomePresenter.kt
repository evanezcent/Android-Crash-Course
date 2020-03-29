package id.kotlin.sa_second.presentation

import id.kotlin.sa_second.di.module.ApiProvider
import id.kotlin.sa_second.data.DataSource
import id.kotlin.sa_second.data.Response
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback

class HomePresenter(
    private val view: HomeView,
    private val datasource: DataSource
) {

    fun getMovie(){
        view.onShowLoading()

        datasource.getMovie().enqueue(object : Callback<Response>{
            override fun onFailure(call: Call<Response>, t: Throwable) {
                view.onHideLoading()
                view.onFailure(t)
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                view.onHideLoading()
                view.onResponse(response.body()?.res?: emptyList())
            }
        })
    }
}