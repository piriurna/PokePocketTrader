package com.piriurna.pokepockettrader.domain.pokemon.repositories

import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getLocalPokemonList(nickname: String): Flow<List<Pokemon>>

    suspend fun getPokemonList(): List<Pokemon>

    suspend fun insertPokemonList(pokemonList: List<Pokemon>)

    suspend fun addOwnedPokemon(pokemon: Pokemon, nickname: String)
}