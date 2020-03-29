package id.kotlin.sa_second.presentation

import id.kotlin.sa_second.di.module.ApiProvider
import id.kotlin.sa_second.data.DataSource
import id.kotlin.sa_second.data.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback

class HomePresenter(
    private val view: HomeView,
    private val datasource: DataSource
) {

    private val dispos: CompositeDisposable= CompositeDisposable()

    fun getMovie(){
        view.onShowLoading()

        datasource.getMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                view.onHideLoading()
                view.onResponse(response.res)
            },{ err ->
                view.onHideLoading()
                view.onFailure(err)
            }).addTo(dispos)
    }

    fun onDetach(){
        dispos.clear()
    }
}