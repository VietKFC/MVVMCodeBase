package com.example.mvvmcodebase.data

import com.example.mvvmcodebase.data.model.Cocktail

interface CocktailDataSource {

    fun getCocktails(letter: String, callback: GetDataCallback<List<Cocktail>>)
    fun onCancel()
}
