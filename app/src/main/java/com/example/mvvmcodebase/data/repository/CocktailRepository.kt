package com.example.mvvmcodebase.data.repository

import com.example.mvvmcodebase.data.CocktailDataSource

class CocktailRepository(private val cocktailDataSource: CocktailDataSource) {

    suspend fun getCocktails(letter: String) = cocktailDataSource.getCocktails(letter)
}
