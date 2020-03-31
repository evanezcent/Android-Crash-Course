package id.kotlin.sa_mastering.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.sa_mastering.di.module.HomeModule
import id.kotlin.sa_mastering.di.scope.Presentation
import id.kotlin.sa_mastering.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules=[HomeModule::class])
    abstract fun contributeHomeActivity():HomeActivity
}