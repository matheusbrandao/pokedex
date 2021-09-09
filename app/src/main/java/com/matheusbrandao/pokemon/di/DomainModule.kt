package com.matheusbrandao.pokemon.di

import com.matheusbrandao.pokemon.domain.interactor.pokemon.FetchPokemonDetailsUseCase
import com.matheusbrandao.pokemon.domain.interactor.pokemon.FetchPokemonsListUseCase
import org.koin.dsl.module.module

val domainModule = module {

    factory {
        FetchPokemonsListUseCase(get(), get())
    }

    factory {
        FetchPokemonDetailsUseCase(get(), get())
    }
}