package id.kotlin.sa_second

import retrofit2.Call
import retrofit2.Callback
import retrofit2.create

class HomePresenter(private val view: HomeView) {

    fun getMovie(){
        view.onShowLoading()

        val data = ApiProvider.provideHttpAdapter().create(DataSource::class.java)
        data.getMovie().enqueue(object : Callback<Response>{
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