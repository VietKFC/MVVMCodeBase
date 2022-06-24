package com.example.mvvmcodebase

import android.app.Application
import com.example.mvvmcodebase.di.clientModule
import com.example.mvvmcodebase.di.repoModule
import com.example.mvvmcodebase.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    clientModule,
                    repoModule,
                    viewModelModule
                )
            )
        }
    }
}
