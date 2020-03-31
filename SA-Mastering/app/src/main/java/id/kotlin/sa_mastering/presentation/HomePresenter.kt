package id.kotlin.sa_mastering.presentation

import id.kotlin.sa_mastering.data.DataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

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