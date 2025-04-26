package com.piriurna.pokepockettrader.data.repositories

import com.piriurna.pokepockettrader.data.apis.PokemonApi
import com.piriurna.pokepockettrader.data.database.daos.PokemonDao
import com.piriurna.pokepockettrader.data.database.entities.PokemonEntity
import com.piriurna.pokepockettrader.domain.models.Pokemon
import com.piriurna.pokepockettrader.domain.repositories.PokemonRepository
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonDao: PokemonDao
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

    override suspend fun getLocalPokemonList(): List<Pokemon> {
        return pokemonDao.getAll().map {
            Pokemon(
                id = it.id,
                name = it.name,
                cardImageUrl = it.imageUrl
            )
        }
    }

    override suspend fun insertPokemonList(pokemonList: List<Pokemon>) {
        val pokemonEntityList = pokemonList.map {
            PokemonEntity(
                id = it.id,
                name = it.name,
                imageUrl = it.cardImageUrl,
                type = ""
            )
        }
        pokemonDao.insertPokemon(pokemonEntityList)
    }
}