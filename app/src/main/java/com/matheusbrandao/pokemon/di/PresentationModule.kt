package com.matheusbrandao.pokemon.di

import com.matheusbrandao.pokemon.presentation.pokemon.PokemonDetailViewModel
import com.matheusbrandao.pokemon.presentation.pokemon.PokemonListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {

    viewModel {
        PokemonListViewModel(get())
    }

    viewModel {
        PokemonDetailViewModel(get())
    }
}