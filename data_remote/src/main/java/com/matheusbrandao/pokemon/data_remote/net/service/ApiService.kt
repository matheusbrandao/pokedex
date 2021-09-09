package com.matheusbrandao.pokemon.data_remote.net.service

import com.matheusbrandao.pokemon.data_remote.model.PokemonInfoDataEntity
import com.matheusbrandao.pokemon.data_remote.model.PokemonListDataEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon")
    fun fetchPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Observable<PokemonListDataEntity>

    @GET("pokemon/{id}")
    fun fetchPokemonDetails(
        @Path("id") id: String
    ): Observable<PokemonInfoDataEntity>
}