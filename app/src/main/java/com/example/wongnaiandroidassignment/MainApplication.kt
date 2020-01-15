package com.example.wongnaiandroidassignment

import android.app.Application
import com.example.wongnaiandroidassignment.di.appModule
import com.example.wongnaiandroidassignment.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    networkModule
                )
            )
        }
    }
}