package com.piriurna.pokepockettrader.domain.usecases

import com.piriurna.pokepockettrader.domain.models.Pokemon
import com.piriurna.pokepockettrader.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(): List<Pokemon> {
        val localPokemons = pokemonRepository.getLocalPokemonList()

        if(localPokemons.isEmpty()) {
            val remotePokemonList = pokemonRepository.getPokemonList()

            pokemonRepository.insertPokemonList(remotePokemonList)
        }

        return pokemonRepository.getLocalPokemonList()
    }
}