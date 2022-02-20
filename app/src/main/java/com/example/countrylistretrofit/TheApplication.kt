package com.example.countrylistretrofit

import android.app.Application
import android.app.usage.UsageEvents.Event.NONE
import com.example.countrylistretrofit.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import java.util.logging.Level

class TheApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) org.koin.core.logger.Level.ERROR else org.koin.core.logger.Level.NONE)
            androidContext(this@TheApplication) // Application context
            modules(listOf(appModule))
        }
    }
}