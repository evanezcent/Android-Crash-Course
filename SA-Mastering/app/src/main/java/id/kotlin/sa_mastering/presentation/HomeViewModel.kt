package id.kotlin.sa_mastering.presentation

import androidx.databinding.BaseObservable
import id.kotlin.sa_mastering.data.DataSource

class HomeViewModel(
    private val callback : HomeViewModelCallback
    private val data : DataSource
): BaseObservable(), HomeView {
}