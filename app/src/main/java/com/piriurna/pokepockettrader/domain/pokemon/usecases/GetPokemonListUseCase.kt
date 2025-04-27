package com.piriurna.pokepockettrader.domain.pokemon.usecases

import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.domain.pokemon.repositories.PokemonRepository
import com.piriurna.pokepockettrader.domain.root.Resource
import com.piriurna.pokepockettrader.domain.user.LoggedUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val loggedUser: LoggedUser
) {

    operator fun invoke(): Flow<Resource<List<Pokemon>>> = flow {
        emit(Resource.Loading())

        val loggedUser = loggedUser.getLoggedInNickname()

        if (loggedUser == null) {
            emit(Resource.Error("User not logged in"))
            return@flow
        }

        val shouldFetchRemote = pokemonRepository.getLocalPokemonList(loggedUser)
            .first()
            .isEmpty()

        if (shouldFetchRemote) {
            val remotePokemonList = pokemonRepository.getPokemonList()
            pokemonRepository.insertPokemonList(remotePokemonList)
        }

        pokemonRepository.getLocalPokemonList(loggedUser).collect { localPokemons ->
            emit(Resource.Success(localPokemons))
        }
    }.catch { e ->
        emit(Resource.Error(e.message ?: "Unknown error"))
    }
}