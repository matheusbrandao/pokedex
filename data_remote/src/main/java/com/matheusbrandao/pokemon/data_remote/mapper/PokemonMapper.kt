package com.matheusbrandao.pokemon.data_remote.mapper

import com.matheusbrandao.pokemon.data_remote.model.PokemonDataEntity
import com.matheusbrandao.pokemon.domain.Pokemon

object PokemonMapper : Mapper<PokemonDataEntity, Pokemon> {

    override fun fromRemote(remote: PokemonDataEntity): Pokemon {
        val pokemonId = getPokemonId(remote.url)
        return Pokemon(
            id = pokemonId,
            url = remote.url,
            urlImage = getUrlImage(pokemonId),
            name = remote.name
        )
    }

    override fun toRemote(domain: Pokemon): PokemonDataEntity {
        TODO("Not yet implemented")
    }

    private fun getPokemonId(url: String) =
        if (url.endsWith("/")) {
            url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            url.takeLastWhile { it.isDigit() }
        }

    private fun getUrlImage(id: String): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
    }
}