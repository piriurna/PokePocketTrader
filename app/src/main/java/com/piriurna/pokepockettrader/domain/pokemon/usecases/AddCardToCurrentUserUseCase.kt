package com.piriurna.pokepockettrader.domain.pokemon.usecases

import android.database.SQLException
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.domain.pokemon.repositories.PokemonRepository
import com.piriurna.pokepockettrader.domain.root.Resource
import com.piriurna.pokepockettrader.domain.user.LoggedUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddCardToCurrentUserUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val loggedUser: LoggedUser
) {


    operator fun invoke(pokemon: Pokemon): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())

        if(loggedUser.getLoggedInNickname() == null) {
            emit(Resource.Error("User not Logged in"))
            return@flow
        }

        try {
            pokemonRepository.addOwnedPokemon(pokemon, loggedUser.getLoggedInNickname()!!)
            emit(Resource.Success(Unit))
        } catch (e: SQLException) {
            emit(Resource.Error("Error inserting into database. ${e.message}"))
        }
    }
}