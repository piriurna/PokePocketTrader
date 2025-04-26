package com.piriurna.pokepockettrader.domain.pokemon.repositories

import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon

interface PokemonRepository {
    suspend fun getLocalPokemonList(): List<Pokemon>

    suspend fun getPokemonList(): List<Pokemon>

    suspend fun insertPokemonList(pokemonList: List<Pokemon>)
}