package id.kotlin.sa_mastering

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.kotlin.sa_mastering.di.component.DaggerApplicationComponent

class BelajarApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply { inject(this@BelajarApp) }
    }
}