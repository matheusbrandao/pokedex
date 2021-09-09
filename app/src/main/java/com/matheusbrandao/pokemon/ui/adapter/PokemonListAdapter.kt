package com.matheusbrandao.pokemon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.matheusbrandao.pokemon.databinding.ItemPokemonListBinding
import com.matheusbrandao.pokemon.presentation.pokemon.PokemonBinding
import com.matheusbrandao.pokemon.ui.holder.PokemonViewHolder
import com.matheusbrandao.pokemon.ui.utils.OnItemClickListener

class PokemonListAdapter(
    items: List<PokemonBinding>,
    private val onClickListener: OnItemClickListener<PokemonBinding>
) :
    BaseListAdapter<PokemonBinding, PokemonViewHolder>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemPokemonListBinding.inflate(
            layoutInflater, parent, false
        )
        return PokemonViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = getItemByPosition(position)
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(item)
        }
    }
}