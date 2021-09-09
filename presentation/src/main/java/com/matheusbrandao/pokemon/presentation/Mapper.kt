package com.matheusbrandao.pokemon.presentation

interface Mapper<D, P> {
    fun fromDomain(domain: D): P
}
