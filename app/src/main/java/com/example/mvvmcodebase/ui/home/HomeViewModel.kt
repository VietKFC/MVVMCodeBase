package com.example.mvvmcodebase.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcodebase.data.GetDataCallback
import com.example.mvvmcodebase.data.model.Cocktail
import com.example.mvvmcodebase.data.repository.CocktailRepository

class HomeViewModel(private val repository: CocktailRepository) : ViewModel() {

    private val _cocktails = MutableLiveData<List<Cocktail>>().apply { value = emptyList() }
    val cocktails: LiveData<List<Cocktail>> = _cocktails

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> = _isError

    fun getCocktails(letter: String) {
        repository.getCocktails(letter, object : GetDataCallback<List<Cocktail>> {
            override fun onSuccess(data: List<Cocktail>) {
                _isError.value = true
                _cocktails.value = data
            }

            override fun onFailed() {
                _isError.value = false
            }
        })
    }
}
