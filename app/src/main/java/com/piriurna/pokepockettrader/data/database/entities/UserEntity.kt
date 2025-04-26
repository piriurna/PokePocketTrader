package com.piriurna.pokepockettrader.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "user"
)
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val nickname: String,
    val email: String,
    val friendNumber: String

)
