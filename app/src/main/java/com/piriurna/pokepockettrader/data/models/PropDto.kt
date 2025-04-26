package com.piriurna.pokepockettrader.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PropDto(
    @SerialName("name")
    val name: String,
    @SerialName("value")
    val value: String
)