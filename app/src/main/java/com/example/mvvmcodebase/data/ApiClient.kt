package com.example.mvvmcodebase.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
    private var apiService: ApiService? = null

    fun build(): ApiService {

        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(ApiService::class.java)
    }

}
