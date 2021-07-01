package com.example.mvvmcodebase.di

import com.example.mvvmcodebase.data.ApiClient
import com.example.mvvmcodebase.data.CocktailDataSource
import com.example.mvvmcodebase.data.repository.CocktailRepository
import com.example.mvvmcodebase.data.source.CocktailRemoteDataSource
import org.koin.dsl.module

val repoModule = module {
    single<CocktailDataSource> { CocktailRemoteDataSource(ApiClient) }
    single { CocktailRepository(get()) }
}
