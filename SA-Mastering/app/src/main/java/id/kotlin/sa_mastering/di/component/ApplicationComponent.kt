package id.kotlin.sa_mastering.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.kotlin.sa_mastering.BelajarApp
import id.kotlin.sa_mastering.di.module.ApiProvider
import javax.inject.Singleton

@Singleton
@Component(modules =  [
    AndroidSupportInjectionModule::class,
    ApiProvider::class,
    ActivityBuilder::class
])

interface ApplicationComponent: AndroidInjector<BelajarApp>