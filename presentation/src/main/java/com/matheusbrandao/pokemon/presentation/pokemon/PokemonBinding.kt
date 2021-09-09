package com.matheusbrandao.pokemon.presentation.pokemon

import java.io.Serializable

data class PokemonBinding(
    val id: String,
    val url: String,
    val urlImage: String,
    val name: String
) : Serializable