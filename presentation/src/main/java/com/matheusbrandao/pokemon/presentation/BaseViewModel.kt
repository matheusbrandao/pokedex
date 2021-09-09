package com.matheusbrandao.pokemon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel() : ViewModel() {

    protected val _dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading

    protected val _errorMessage = MutableLiveData<String>().apply { value = "" }
    val errorMessage: LiveData<String>
        get() = _errorMessage
}