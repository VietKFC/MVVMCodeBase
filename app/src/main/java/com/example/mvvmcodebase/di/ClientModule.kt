package com.example.mvvmcodebase.di

import com.example.mvvmcodebase.data.ApiClient
import org.koin.dsl.module

val clientModule = module {
    single { ApiClient.build() }
}
