package com.piriurna.pokepockettrader.data.pokemon.entities

import androidx.room.Embedded

data class UserOwnedPokemon(
    @Embedded val pokemon: PokemonEntity,
    // other Pokemon fields
    val isOwned: Boolean
)