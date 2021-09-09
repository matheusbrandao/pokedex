package com.matheusbrandao.pokemon.di

import com.matheusbrandao.pokemon.data_remote.net.service.ApiService
import org.koin.dsl.module.module
import retrofit2.Retrofit

val serviceModule = module {
    factory {
        createWebService<ApiService>(get())
    }
}

inline fun <reified T> createWebService(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}