package com.piriurna.pokepockettrader.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DemandDto(
    @SerialName("amount")
    val amount: String,
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String
)