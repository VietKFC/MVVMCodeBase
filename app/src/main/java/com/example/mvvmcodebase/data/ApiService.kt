package com.example.mvvmcodebase.data

import com.example.mvvmcodebase.data.model.CocktailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php")
    fun getDrinks(@Query("f") letter: String): Call<CocktailResponse>
}
