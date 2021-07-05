package com.example.mvvmcodebase.data.model

import com.google.gson.annotations.SerializedName

data class Cocktail(
    @SerializedName("idDrink")
    val id: Int,
    @SerializedName("strDrink")
    val name: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strDrinkThumb")
    val thumb: String
)
