package com.piriurna.pokepockettrader.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    @SerialName("ability")
    val ability: List<Ability>,
    @SerialName("attack")
    val attack: List<Attack>,
    @SerialName("color")
    val color: String,
    @SerialName("delta7dPrice")
    val delta7dPrice: String,
    @SerialName("delta7dPriceFoil")
    val delta7dPriceFoil: String,
    @SerialName("deltaFoilPrice")
    val deltaFoilPrice: String,
    @SerialName("deltaPrice")
    val deltaPrice: String,
    @SerialName("dex")
    val dex: String,
    @SerialName("flairs")
    val flairs: List<Flair>,
    @SerialName("foilPrice")
    val foilPrice: String,
    @SerialName("has_art")
    val hasArt: String,
    @SerialName("has_image")
    val hasImage: String,
    @SerialName("hp")
    val hp: String,
    @SerialName("id")
    val id: String,
    @SerialName("illustrator")
    val illustrator: String,
    @SerialName("name")
    val name: String,
    @SerialName("number")
    val number: String,
    @SerialName("prew_stage_name")
    val prewStageName: String,
    @SerialName("price")
    val price: String,
    @SerialName("price_date")
    val priceDate: String,
    @SerialName("props")
    val props: List<Prop>,
    @SerialName("rarity")
    val rarity: String,
    @SerialName("retreat")
    val retreat: String,
    @SerialName("rule")
    val rule: String,
    @SerialName("set_code")
    val setCode: String,
    @SerialName("setId")
    val setId: String,
    @SerialName("set_name")
    val setName: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("stage")
    val stage: String,
    @SerialName("text")
    val text: String,
    @SerialName("type")
    val type: String,
    @SerialName("weakness")
    val weakness: String
)