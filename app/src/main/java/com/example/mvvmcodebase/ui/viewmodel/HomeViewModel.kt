package com.example.mvvmcodebase.ui.viewmodel

import androidx.lifecycle.*
import com.example.mvvmcodebase.data.model.Cocktail
import com.example.mvvmcodebase.data.repository.CocktailRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CocktailRepository) : ViewModel() {

    private val _cocktails = MutableLiveData<List<Cocktail>>(emptyList())
    val cocktails: LiveData<List<Cocktail>>

    private val _isError = MutableLiveData<String>()
    val isError: LiveData<String> = _isError

    private val _cocktailLetter = MutableLiveData("")

    init {
        cocktails = Transformations.switchMap(_cocktailLetter, ::getCocktails)
    }

    private fun getCocktails(letter: String): LiveData<List<Cocktail>> {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            _isError.value = throwable.message
        }

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _cocktails.postValue(repository.getCocktails(letter).drinks)
        }
        return _cocktails
    }

    fun setCocktailLetter(letter: String) {
        _cocktailLetter.value = letter
    }
}
