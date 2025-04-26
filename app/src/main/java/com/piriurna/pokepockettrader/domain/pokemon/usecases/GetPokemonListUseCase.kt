package com.piriurna.pokepockettrader.domain.pokemon.usecases

import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.domain.pokemon.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(nickname: String): Flow<List<Pokemon>> {
        val localPokemons = pokemonRepository.getLocalPokemonList(nickname).firstOrNull()

        if(localPokemons?.isEmpty() == true) {
            val remotePokemonList = pokemonRepository.getPokemonList()

            pokemonRepository.insertPokemonList(remotePokemonList)
        }

        return pokemonRepository.getLocalPokemonList(nickname)
    }
}