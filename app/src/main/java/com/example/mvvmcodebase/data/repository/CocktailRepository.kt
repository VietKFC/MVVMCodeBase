package com.example.mvvmcodebase.data.repository

import com.example.mvvmcodebase.data.CocktailDataSource
import com.example.mvvmcodebase.data.GetDataCallback
import com.example.mvvmcodebase.data.model.Cocktail

class CocktailRepository(private val cocktailDataSource: CocktailDataSource) {

    fun getCocktails(letter: String, callback: GetDataCallback<List<Cocktail>>) {
        cocktailDataSource.getCocktails(letter, callback)
    }

    fun cancel() {
        cocktailDataSource.onCancel()
    }
}
