package com.matheusbrandao.pokemon.presentation.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.matheusbrandao.pokemon.domain.interactor.pokemon.FetchPokemonsListUseCase
import com.matheusbrandao.pokemon.presentation.BaseViewModel
import timber.log.Timber

class PokemonListViewModel(
    private val useCase: FetchPokemonsListUseCase
) : BaseViewModel() {

    private val _items = MutableLiveData<List<PokemonBinding>>().apply { value = emptyList() }
    val items: LiveData<List<PokemonBinding>>
        get() = _items

    fun fetchPokemons(offset: Int) {
        _dataLoading.value = true

        useCase.execute(
            FetchPokemonsListUseCase.Params(
                offset = offset
            ),
            {
                val listPokemons = it.map { pokemon ->
                    PokemonDataMapper.fromDomain(pokemon)
                }

                _items.apply {
                    val newList = this.value?.toMutableList()
                    newList?.addAll(listPokemons)
                    value = newList
                }

                _dataLoading.value = false
            },
            {
                Timber.e("Error: ${it.message.toString()}")
                _errorMessage.value = it.message
                _dataLoading.value = false
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        useCase.dispose()
    }
}