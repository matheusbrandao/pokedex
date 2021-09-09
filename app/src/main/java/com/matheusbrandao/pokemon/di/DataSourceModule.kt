package com.matheusbrandao.pokemon.di

import com.matheusbrandao.pokemon.data.api.ApiRemoteDataSource
import com.matheusbrandao.pokemon.data_remote.ApiRemoteDataSourceImpl
import org.koin.dsl.module.module

val dataSourceModule = module {

    factory {
        ApiRemoteDataSourceImpl(get()) as ApiRemoteDataSource
    }
}