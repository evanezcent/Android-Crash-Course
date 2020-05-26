package id.kotlin.sa_second.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.sa_second.data.DataSource
import id.kotlin.sa_second.presentation.HomeActivity
import id.kotlin.sa_second.presentation.HomeView
import id.kotlin.sa_second.presentation.HomeViewModel
import id.kotlin.sa_second.presentation.HomeViewModelCallback
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object{

        @JvmStatic @Provides
        fun provideDatasource(retrofit: Retrofit):DataSource = retrofit.create(DataSource::class.java)

        @JvmStatic @Provides
        fun provideHomeViewModel(
            callback: HomeViewModelCallback,
            datasource: DataSource
        ): HomeViewModel = HomeViewModel(callback, datasource)
    }

    @Binds
    abstract fun bindHomeViewCallback(activity: HomeActivity):HomeViewModelCallback
}