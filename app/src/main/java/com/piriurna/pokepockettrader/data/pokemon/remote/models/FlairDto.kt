package com.piriurna.pokepockettrader.data.pokemon.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlairDto(
    @SerialName("flairs")
    val flairs: List<FlairXDto>,
    @SerialName("routeName")
    val routeName: String
)