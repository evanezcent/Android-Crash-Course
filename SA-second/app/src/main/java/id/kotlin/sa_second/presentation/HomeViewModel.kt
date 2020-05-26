package id.kotlin.sa_second.presentation

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import id.kotlin.sa_second.data.DataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class HomeViewModel (
    private val callback : HomeViewModelCallback,
    private val datasource : DataSource
):BaseObservable(), HomeView{
    var loadingBar: Int = View.GONE
        @Bindable get

    private val disposavle: CompositeDisposable = CompositeDisposable()

    override fun getMovies() {
        loadingBar = View.VISIBLE
        notifyPropertyChanged(BR.loadingBar)

        datasource.getMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                loadingBar=View.GONE
                notifyPropertyChanged(BR.loadingBar)
                callback.onSuccess(response.res)
            },{err ->
                loadingBar = View.GONE
                notifyPropertyChanged(BR.loadingBar)
                callback.onError(err)
            }).addTo(disposavle)
    }

    override fun onDetach() {
        disposavle.clear()
    }

}