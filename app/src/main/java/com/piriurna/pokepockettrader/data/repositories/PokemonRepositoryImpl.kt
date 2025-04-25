package com.piriurna.pokepockettrader.data.repositories

import com.piriurna.pokepockettrader.data.apis.PokemonApi
import com.piriurna.pokepockettrader.domain.models.Pokemon
import com.piriurna.pokepockettrader.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
): PokemonRepository {
    override suspend fun getPokemonList(): List<Pokemon> {
        return pokemonApi.getAllPokemon().map {
            Pokemon(
                id = it.id,
                name = it.name,
                cardImageUrl = "https://static.dotgg.gg/pokepocket/card/${it.id}.webp"
            )
        }
    }
}