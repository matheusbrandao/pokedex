package com.matheusbrandao.pokemon.data.api

import com.matheusbrandao.pokemon.domain.Pokemon
import com.matheusbrandao.pokemon.domain.PokemonDetails
import com.matheusbrandao.pokemon.domain.repository.ApiRepository
import io.reactivex.Observable

class ApiRepositoryImpl(
    private val remoteDataSource: ApiRemoteDataSource
) : ApiRepository {

    override fun fetchPokemonsList(offset: Int): Observable<List<Pokemon>> {
        return remoteDataSource.fetchPokemonsList(offset)
    }

    override fun fetchPokemonDetails(id: String): Observable<PokemonDetails> {
        return remoteDataSource.fetchPokemonDetails(id)
    }
}