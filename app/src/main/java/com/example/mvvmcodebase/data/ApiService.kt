package com.example.mvvmcodebase.data

import com.example.mvvmcodebase.data.model.CocktailResponse
import com.example.mvvmcodebase.utils.ApiConstant
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiConstant.SEARCH_QUERY)
    suspend fun getDrinks(@Query("f") letter: String): CocktailResponse
}
