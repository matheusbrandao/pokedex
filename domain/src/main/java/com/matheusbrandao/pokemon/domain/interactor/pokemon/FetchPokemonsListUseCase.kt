package com.matheusbrandao.pokemon.domain.interactor.pokemon

import com.matheusbrandao.pokemon.domain.Pokemon
import com.matheusbrandao.pokemon.domain.executor.PostExecutionThread
import com.matheusbrandao.pokemon.domain.interactor.ObservableUseCase
import com.matheusbrandao.pokemon.domain.repository.ApiRepository
import io.reactivex.Observable

class FetchPokemonsListUseCase(
    postExecutionThread: PostExecutionThread,
    private val repository: ApiRepository
) : ObservableUseCase<List<Pokemon>, FetchPokemonsListUseCase.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<List<Pokemon>> {
        checkNotNull(params)
        return repository.fetchPokemonList(params.offset)
    }

    data class Params(val offset: Int)
}