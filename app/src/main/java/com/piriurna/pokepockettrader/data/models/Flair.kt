package com.piriurna.pokepockettrader.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Flair(
    @SerialName("flairs")
    val flairs: List<FlairX>,
    @SerialName("routeName")
    val routeName: String
)