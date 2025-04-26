package com.piriurna.pokepockettrader.data.pokemon.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.piriurna.pokepockettrader.data.user.entities.UserEntity

@Entity(
    tableName = "OwnedPokemon",
    foreignKeys = [
        ForeignKey(
            entity = PokemonEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("pokemonId"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = arrayOf("nickname"),
            childColumns = arrayOf("ownerId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OwnedPokemonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val pokemonId: String,
    val ownerId: String
)