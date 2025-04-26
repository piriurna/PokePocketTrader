package com.piriurna.pokepockettrader.domain.pokemon.usecases

import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.domain.pokemon.repositories.PokemonRepository
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