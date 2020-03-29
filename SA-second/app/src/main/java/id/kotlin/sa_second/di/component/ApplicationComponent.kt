package id.kotlin.sa_second.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.kotlin.sa_second.BelajarApp
import id.kotlin.sa_second.di.builder.ActivityBuilder
import id.kotlin.sa_second.di.module.ApiProvider
import javax.inject.Singleton

@Singleton
@Component(modules =  [
    AndroidSupportInjectionModule::class,
    ApiProvider::class,
    ActivityBuilder::class
])

interface ApplicationComponent: AndroidInjector<BelajarApp>