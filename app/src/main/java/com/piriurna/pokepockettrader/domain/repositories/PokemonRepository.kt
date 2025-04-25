package com.piriurna.pokepockettrader.domain.repositories

import com.piriurna.pokepockettrader.domain.models.Pokemon

interface PokemonRepository {

    suspend fun getPokemonList(): List<Pokemon>
}