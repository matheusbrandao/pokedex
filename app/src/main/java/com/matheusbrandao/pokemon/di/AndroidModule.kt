package com.matheusbrandao.pokemon.di

import com.matheusbrandao.pokemon.domain.executor.PostExecutionThread
import com.matheusbrandao.pokemon.ui.executor.UiThread
import org.koin.dsl.module.module

val androidModule = module {

    single { this }

    single {
        UiThread() as PostExecutionThread
    }

}