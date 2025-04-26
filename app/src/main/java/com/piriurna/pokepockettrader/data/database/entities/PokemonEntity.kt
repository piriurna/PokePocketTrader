package com.piriurna.pokepockettrader.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemon",
    foreignKeys = []
)
class PokemonEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val imageUrl: String,
    val type: String,
)