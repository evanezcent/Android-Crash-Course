package id.kotlin.sa_second.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import id.kotlin.sa_second.data.DataSource
import id.kotlin.sa_second.di.scope.ViewModelKey
import id.kotlin.sa_second.presentation.HomeViewModel
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object{

        @JvmStatic @Provides
        fun provideDatasource(retrofit: Retrofit):DataSource = retrofit.create(DataSource::class.java)
    }

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel):ViewModel
}