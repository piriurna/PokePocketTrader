package com.piriurna.pokepockettrader.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlairXDto(
    @SerialName("count")
    val count: String,
    @SerialName("demands")
    val demandDtos: List<DemandDto>,
    @SerialName("from_date")
    val fromDate: Int,
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("prerequisite_count")
    val prerequisiteCount: String,
    @SerialName("prerequisite_name")
    val prerequisiteName: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("type")
    val type: String
)