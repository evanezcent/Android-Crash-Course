package id.kotlin.sa_second.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.sa_second.di.factory.ViewModelFactory
import id.kotlin.sa_second.di.module.HomeModule
import id.kotlin.sa_second.di.scope.Presentation
import id.kotlin.sa_second.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory):ViewModelProvider.Factory

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity():HomeActivity
}