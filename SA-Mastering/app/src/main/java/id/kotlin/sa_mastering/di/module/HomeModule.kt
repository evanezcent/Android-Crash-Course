package id.kotlin.sa_mastering.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.sa_mastering.data.DataSource
import id.kotlin.sa_mastering.presentation.HomeActivity
import id.kotlin.sa_mastering.presentation.HomePresenter
import id.kotlin.sa_mastering.presentation.HomeView
import retrofit2.Retrofit

@Module
abstract class HomeModule