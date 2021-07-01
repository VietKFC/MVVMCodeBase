package com.example.mvvmcodebase

import android.app.Application
import com.example.mvvmcodebase.di.repoModule
import com.example.mvvmcodebase.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    repoModule,
                    viewModelModule
                )
            )

        }
    }
}
