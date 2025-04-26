package com.piriurna.pokepockettrader.domain.models

data class Pokemon(
    val id: String,
    val name: String,
    val cardImageUrl: String,
) {

    companion object {
        val dummyPokemonList =
            (0..10).map { index ->
                Pokemon(
                    id = "$index",
                    name = "dummy",
                    cardImageUrl = "dummy"
                )
            }
    }
}