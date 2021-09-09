package com.matheusbrandao.pokemon.domain.interactor.pokemon

import com.matheusbrandao.pokemon.domain.PokemonDetails
import com.matheusbrandao.pokemon.domain.executor.PostExecutionThread
import com.matheusbrandao.pokemon.domain.interactor.ObservableUseCase
import com.matheusbrandao.pokemon.domain.repository.ApiRepository
import io.reactivex.Observable

class FetchPokemonDetailsUseCase(
    postExecutionThread: PostExecutionThread,
    private val repository: ApiRepository
) : ObservableUseCase<PokemonDetails, FetchPokemonDetailsUseCase.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<PokemonDetails> {
        checkNotNull(params)
        return repository.fetchPokemonDetails(params.id)
    }

    data class Params(val id: String)
}