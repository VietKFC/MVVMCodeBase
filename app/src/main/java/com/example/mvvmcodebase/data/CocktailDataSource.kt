package com.example.mvvmcodebase.data

import com.example.mvvmcodebase.data.model.Cocktail
import com.example.mvvmcodebase.data.model.CocktailResponse

interface CocktailDataSource {

    interface Remote {
        suspend fun getCocktails(letter: String): CocktailResponse
    }

    interface Local {
        suspend fun getCocktailsFromDb(letter: String): List<Cocktail>
    }
}
