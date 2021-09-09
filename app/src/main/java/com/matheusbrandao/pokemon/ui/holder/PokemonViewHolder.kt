package com.matheusbrandao.pokemon.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.pokemon.presentation.pokemon.PokemonBinding
import com.matheusbrandao.pokemon.databinding.ItemPokemonListBinding

class PokemonViewHolder(
    private val binding: ItemPokemonListBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: PokemonBinding) {
        binding.pokemon = pokemon
        binding.executePendingBindings()
    }
}