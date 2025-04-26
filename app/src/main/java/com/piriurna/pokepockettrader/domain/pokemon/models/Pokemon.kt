package com.piriurna.pokepockettrader.domain.pokemon.models

data class Pokemon(
    val id: String,
    val name: String,
    val cardImageUrl: String,
    val owned: Boolean
) {

    companion object {
        val dummyPokemonList =
            (0..10).map { index ->
                Pokemon(
                    id = "$index",
                    name = "dummy",
                    cardImageUrl = "dummy",
                    owned = true
                )
            }
    }
}