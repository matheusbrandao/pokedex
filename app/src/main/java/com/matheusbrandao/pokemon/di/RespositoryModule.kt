package com.matheusbrandao.pokemon.di

import com.matheusbrandao.pokemon.data.api.ApiRepositoryImpl
import com.matheusbrandao.pokemon.domain.repository.ApiRepository
import org.koin.dsl.module.module

val repositoryModule = module {

    factory {
        ApiRepositoryImpl(
            get()
        ) as ApiRepository
    }
}