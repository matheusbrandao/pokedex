package com.matheusbrandao.pokemon.presentation.pokemon

import java.io.Serializable

data class PokemonDetailsBinding(
    val name: String,
    val type: String,
    val weight: String,
    val height: String
) : Serializable