package com.matheusbrandao.pokemon.data_remote.model

data class PokemonInfoDataEntity(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val types: List<TypeDataEntity>
)