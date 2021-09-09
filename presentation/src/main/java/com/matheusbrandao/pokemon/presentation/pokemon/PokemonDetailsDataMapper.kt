package com.matheusbrandao.pokemon.presentation.pokemon

import com.matheusbrandao.pokemon.domain.PokemonDetails
import com.matheusbrandao.pokemon.presentation.Mapper

object PokemonDetailsDataMapper : Mapper<PokemonDetails, PokemonDetailsBinding> {

    override fun fromDomain(domain: PokemonDetails): PokemonDetailsBinding {
        return PokemonDetailsBinding(
            name = domain.name,
            type = domain.type,
            weight = domain.weight.toString(),
            height = domain.height.toString()
        )
    }
}