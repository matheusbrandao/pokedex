package com.matheusbrandao.pokemon.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.pokemon.presentation.pokemon.PokemonBinding
import com.matheusbrandao.pokemon.ui.adapter.BaseListAdapter

object PokemonListBindings {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<PokemonBinding>?) {
        items?.let {
            with(recyclerView.adapter as BaseListAdapter<PokemonBinding, *>) {
                replaceData(items)
            }
        }
    }
}
