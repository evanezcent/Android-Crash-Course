package id.kotlin.sa_mastering.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import id.kotlin.sa_mastering.data.Result

class HomeAdapterViewModel (res : Result): BaseObservable(){

    val title: String = res.title
    @Bindable get

    val overview: String = res.overview
    @Bindable get
}