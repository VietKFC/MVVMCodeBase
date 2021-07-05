package com.example.mvvmcodebase.data

import com.example.mvvmcodebase.data.model.CocktailResponse

interface CocktailDataSource {

    suspend fun getCocktails(letter: String): CocktailResponse
}
