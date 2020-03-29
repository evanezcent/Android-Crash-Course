package id.kotlin.sa_second

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.kotlin.sa_second.di.component.DaggerApplicationComponent

class BelajarApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply { inject(this@BelajarApp) }
    }
}