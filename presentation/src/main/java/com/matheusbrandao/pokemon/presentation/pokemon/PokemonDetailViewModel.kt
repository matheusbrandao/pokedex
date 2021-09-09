package com.matheusbrandao.pokemon.presentation.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.matheusbrandao.pokemon.domain.interactor.pokemon.FetchPokemonDetailsUseCase
import com.matheusbrandao.pokemon.presentation.BaseViewModel
import timber.log.Timber

class PokemonDetailViewModel(
    private val useCase: FetchPokemonDetailsUseCase
) : BaseViewModel() {

    private val _item = MutableLiveData<PokemonDetailsBinding>()
    val item: LiveData<PokemonDetailsBinding>
        get() = _item

    fun getDetails(id: String) {
        _dataLoading.value = true

        useCase.execute(FetchPokemonDetailsUseCase.Params(id = id),
            {
                _item.value = PokemonDetailsDataMapper.fromDomain(it)
                _dataLoading.value = false
            },
            {
                Timber.e("Error: ${it.message.toString()}")
                _errorMessage.value = it.message
                _dataLoading.value = false
            })
    }

    override fun onCleared() {
        super.onCleared()
        useCase.dispose()
    }
}