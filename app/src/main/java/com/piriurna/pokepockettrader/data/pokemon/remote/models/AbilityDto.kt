package com.piriurna.pokepockettrader.data.pokemon.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityDto(
    @SerialName("effect")
    val effect: String,
    @SerialName("info")
    val info: String
)