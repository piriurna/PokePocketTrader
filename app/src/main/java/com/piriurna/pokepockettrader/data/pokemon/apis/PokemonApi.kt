package com.piriurna.pokepockettrader.data.pokemon.apis

import com.piriurna.pokepockettrader.data.pokemon.remote.models.PokemonListDto
import retrofit2.http.GET

interface PokemonApi {

    @GET("getcards?game=pokepocket")
    suspend fun getAllPokemon(): PokemonListDto
}