package com.matheusbrandao.pokemon.presentation.pokemon

import com.matheusbrandao.pokemon.domain.Pokemon
import com.matheusbrandao.pokemon.presentation.Mapper

object PokemonDataMapper :
    Mapper<Pokemon, PokemonBinding> {

    override fun fromDomain(domain: Pokemon): PokemonBinding {
        return PokemonBinding(
            id = domain.id,
            url = domain.url,
            urlImage = domain.urlImage,
            name = domain.name
        )
    }
}