package id.kotlin.sa_second.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.sa_second.data.DataSource
import id.kotlin.sa_second.presentation.HomeActivity
import id.kotlin.sa_second.presentation.HomePresenter
import id.kotlin.sa_second.presentation.HomeView
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object{

        @JvmStatic @Provides
        fun provideDatasource(retrofit: Retrofit):DataSource = retrofit.create(DataSource::class.java)

        @JvmStatic @Provides
        fun provideHomePresenter(
            view: HomeView,
            datasource: DataSource
        ): HomePresenter = HomePresenter(view, datasource)
    }

    @Binds
    abstract fun bindHomeView(activity: HomeActivity):HomeView
}