package com.piriurna.pokepockettrader.data.pokemon.repositories

import com.piriurna.pokepockettrader.data.pokemon.apis.PokemonApi
import com.piriurna.pokepockettrader.data.pokemon.daos.PokemonDao
import com.piriurna.pokepockettrader.data.pokemon.entities.PokemonEntity
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.domain.pokemon.repositories.PokemonRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonDao: PokemonDao
): PokemonRepository {
    override suspend fun getPokemonList(): List<Pokemon> {
        return pokemonApi.getAllPokemon().map {
            Pokemon(
                id = it.id,
                name = it.name,
                cardImageUrl = "https://static.dotgg.gg/pokepocket/card/${it.id}.webp",
                owned = false
            )
        }
    }

    override suspend fun getLocalPokemonList(nickname: String): Flow<List<Pokemon>> {
        return pokemonDao.getAllPokemonWithOwnership(nickname).map {
            it.map {
                Pokemon(
                    id = it.pokemon.id,
                    name = it.pokemon.name,
                    cardImageUrl = it.pokemon.imageUrl,
                    owned = it.isOwned
                )
            }
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