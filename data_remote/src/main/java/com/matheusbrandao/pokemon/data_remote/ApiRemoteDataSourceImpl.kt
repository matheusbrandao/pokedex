package com.matheusbrandao.pokemon.data_remote

import com.matheusbrandao.pokemon.data.api.ApiRemoteDataSource
import com.matheusbrandao.pokemon.data_remote.mapper.PokemonMapper
import com.matheusbrandao.pokemon.data_remote.mapper.PokemonDetailsMapper
import com.matheusbrandao.pokemon.data_remote.net.service.ApiService
import com.matheusbrandao.pokemon.domain.Pokemon
import com.matheusbrandao.pokemon.domain.PokemonDetails
import io.reactivex.Observable

class ApiRemoteDataSourceImpl(private val service: ApiService) :
    ApiRemoteDataSource {

    override fun fetchPokemonsList(offset: Int): Observable<List<Pokemon>> {
        return service.fetchPokemonList(ITEMS_PER_PAGE, offset).map {
            it.results.map(
                PokemonMapper::fromRemote
            )
        }
    }

    override fun fetchPokemonDetails(id: String): Observable<PokemonDetails> {
        return service.fetchPokemonDetails(id).map {
            PokemonDetailsMapper.fromRemote(it)
        }
    }

    companion object {
        private const val ITEMS_PER_PAGE = 20
    }
}