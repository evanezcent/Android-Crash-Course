package id.kotlin.sa_second.presentation

import androidx.lifecycle.LiveData
import id.kotlin.sa_second.data.Result

interface HomeView {
    val states: LiveData<HomeViewState>
    fun getMovies()
}