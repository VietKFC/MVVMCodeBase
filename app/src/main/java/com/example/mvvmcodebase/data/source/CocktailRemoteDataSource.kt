package com.example.mvvmcodebase.data.source

import com.example.mvvmcodebase.data.ApiService
import com.example.mvvmcodebase.data.CocktailDataSource

class CocktailRemoteDataSource(private val apiService: ApiService) : CocktailDataSource.Remote {

    override suspend fun getCocktails(letter: String) = apiService.getDrinks(letter)
}
