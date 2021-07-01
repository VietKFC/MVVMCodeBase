package com.example.mvvmcodebase.data.source

import com.example.mvvmcodebase.data.ApiClient
import com.example.mvvmcodebase.data.CocktailDataSource
import com.example.mvvmcodebase.data.GetDataCallback
import com.example.mvvmcodebase.data.model.Cocktail
import com.example.mvvmcodebase.data.model.CocktailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CocktailRemoteDataSource(apiClient: ApiClient) : CocktailDataSource {

    private val apiService = apiClient.build()
    private var cocktailCall: Call<CocktailResponse>? = null

    override fun getCocktails(letter: String, callback: GetDataCallback<List<Cocktail>>) {
        cocktailCall = apiService.getDrinks(letter)
        cocktailCall?.enqueue(object : Callback<CocktailResponse> {
            override fun onResponse(
                call: Call<CocktailResponse>,
                response: Response<CocktailResponse>
            ) {
                response.body()?.let {
                    callback.apply {
                        if (response.isSuccessful) onSuccess(it.drinks) else onFailed()
                    }
                }
            }

            override fun onFailure(call: Call<CocktailResponse>, t: Throwable) {
                callback.onFailed()
            }

        })
    }

    override fun onCancel() {
        cocktailCall?.cancel()
    }
}
