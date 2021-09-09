package com.matheusbrandao.pokemon.data_remote.mapper

import com.matheusbrandao.pokemon.data_remote.model.PokemonInfoDataEntity
import com.matheusbrandao.pokemon.domain.PokemonDetails

object PokemonDetailsMapper : Mapper<PokemonInfoDataEntity, PokemonDetails> {

    override fun fromRemote(remote: PokemonInfoDataEntity): PokemonDetails {
        return PokemonDetails(
            id = remote.id.toString(),
            name = remote.name,
            type = remote.types[0].type.name,
            weight = remote.weight,
            height = remote.height
        )
    }

    override fun toRemote(domain: PokemonDetails): PokemonInfoDataEntity {
        TODO("Not yet implemented")
    }
}