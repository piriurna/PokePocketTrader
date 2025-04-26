package com.piriurna.pokepockettrader.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttackDto(
    @SerialName("effect")
    val effect: String,
    @SerialName("info")
    val info: String
)