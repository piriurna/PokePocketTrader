package com.piriurna.pokepockettrader.data.user.entities

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
