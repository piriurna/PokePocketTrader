package com.piriurna.pokepockettrader.domain.user.repositories

import com.piriurna.pokepockettrader.domain.user.models.User

interface UserRepository {

    suspend fun getUserById(nickname: String): User?

    suspend fun insertNewUser(user: User)
}