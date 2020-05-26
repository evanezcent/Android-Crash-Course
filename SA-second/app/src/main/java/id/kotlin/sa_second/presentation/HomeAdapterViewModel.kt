package id.kotlin.sa_second.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import id.kotlin.sa_second.data.Result

class HomeAdapterViewModel (res: Result):BaseObservable(){
    var title: String = res.title
        @Bindable get

    var overview: String = res.overview
        @Bindable get
}
