package id.kotlin.sa_second.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.sql.DataSource
import androidx.lifecycle.MutableLiveData


class HomeViewModel @Inject constructor (
    private val datasource:id.kotlin.sa_second.data.DataSource
):ViewModel(), HomeView{

    private val disposavle = CompositeDisposable()
    private val observer = MutableLiveData<HomeViewState>()

    override val states: LiveData<HomeViewState>
        get() = observer

    override fun onCleared() {
        super.onCleared()
        disposavle.clear()
    }

    override fun getMovies() {
        datasource.getMovie()
            .map<HomeViewState>(HomeViewState::Success)
            .onErrorReturn(HomeViewState::Error)
            .toFlowable()
            .startWith(HomeViewState.Loading)
            .subscribe(observer::postValue)
            .let(disposavle::add)
    }
}