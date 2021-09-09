package com.matheusbrandao.pokemon.data.api

import com.matheusbrandao.pokemon.domain.Pokemon
import com.matheusbrandao.pokemon.domain.PokemonDetails
import io.reactivex.Observable

interface ApiRemoteDataSource {
    fun fetchPokemonsList(offset: Int): Observable<List<Pokemon>>
    fun fetchPokemonDetails(id: String): Observable<PokemonDetails>
}