package com.matheusbrandao.pokemon.domain.repository

import com.matheusbrandao.pokemon.domain.Pokemon
import com.matheusbrandao.pokemon.domain.PokemonDetails
import io.reactivex.Observable

interface ApiRepository {
    fun fetchPokemonsList(offset: Int): Observable<List<Pokemon>>
    fun fetchPokemonDetails(id: String): Observable<PokemonDetails>

}