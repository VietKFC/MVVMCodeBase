package com.example.mvvmcodebase.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcodebase.data.model.Cocktail
import com.example.mvvmcodebase.data.repository.CocktailRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CocktailRepository) : ViewModel() {

    private val _cocktails = MutableLiveData<List<Cocktail>>(emptyList())
    val cocktails: LiveData<List<Cocktail>> = _cocktails

    private val _isError = MutableLiveData<String>()
    val isError: LiveData<String> = _isError

    fun getCocktails(letter: String) {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            _isError.value = throwable.message
        }

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _cocktails.postValue(repository.getCocktails(letter).drinks)
        }

    }
}
