package com.piriurna.pokepockettrader.ui.pokedex

import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon

sealed class PokemonAction(val pokemon: Pokemon) {

    class Remove(pokemon: Pokemon): PokemonAction(pokemon)

    class Add(pokemon: Pokemon): PokemonAction(pokemon)
}

enum class PokemonActionType {
    ADD,
    REMOVE
}
