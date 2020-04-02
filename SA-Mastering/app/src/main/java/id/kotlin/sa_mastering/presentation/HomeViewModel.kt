package id.kotlin.sa_mastering.presentation

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import id.kotlin.sa_mastering.data.DataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class HomeViewModel(
    private val callback : HomeViewModelCallback,
    private val data : DataSource
): BaseObservable(), HomeView {

    var loadingBar: Int = View.GONE
        @Bindable get

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun getTheMovies() {
        loadingBar = View.VISIBLE
        notifyPropertyChanged(BR.loadingBar)

        data.getMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({res ->
                loadingBar = View.GONE
                notifyPropertyChanged(BR.loadingBar)
                callback.onSuccess(res.res)
            },{err ->
                loadingBar = View.GONE
                notifyPropertyChanged(BR.loadingBar)
                callback.onFailed(err)
            }).addTo(disposables)
    }

    override fun onDetach() {
        disposables.clear()
    }


}