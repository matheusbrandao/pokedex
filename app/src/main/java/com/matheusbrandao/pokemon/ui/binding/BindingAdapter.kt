package com.matheusbrandao.pokemon.ui.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("pokemonImage")
    fun loadPokemonImage(view: AppCompatImageView, urlImage: String?) {
        urlImage?.let {
            val options = RequestOptions()
                .centerCrop()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)

            Glide.with(view.context)
                .load(urlImage)
                .apply(options)
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("pokemonDetailImage")
    fun loadPokemonDetailImage(view: AppCompatImageView, urlImage: String?) {
        urlImage?.let {
            val options = RequestOptions()
                .centerCrop()
                .circleCrop()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)

            Glide.with(view.context)
                .load(urlImage)
                .apply(options)
                .into(view)
        }
    }
}