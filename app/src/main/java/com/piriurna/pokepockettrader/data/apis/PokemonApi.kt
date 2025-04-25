package com.piriurna.pokepockettrader.data.apis

import com.piriurna.pokepockettrader.data.models.PokemonListDto
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi {

    @GET("getcards?game=pokepocket")
    suspend fun getAllPokemon(): PokemonListDto
}