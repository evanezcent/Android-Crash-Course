package id.kotlin.sa_second.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.sa_second.di.module.HomeModule
import id.kotlin.sa_second.di.scope.Presentation
import id.kotlin.sa_second.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules=[HomeModule::class])
    abstract fun contributeHomeActivity():HomeActivity
}