package com.example.mvvmcodebase.data.model

import com.google.gson.annotations.SerializedName

data class CocktailResponse(
    @SerializedName("drinks")
    val drinks: List<Cocktail>
)
