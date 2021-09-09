package com.matheusbrandao.pokemon.data_remote.model

data class PokemonListDataEntity(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokemonDataEntity>
)