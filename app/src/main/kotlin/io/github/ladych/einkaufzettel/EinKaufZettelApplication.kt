package io.github.ladych.einkaufzettel

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EinKaufZettelApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EinKaufZettelApplication)
            modules(appModules)
        }
    }
}
