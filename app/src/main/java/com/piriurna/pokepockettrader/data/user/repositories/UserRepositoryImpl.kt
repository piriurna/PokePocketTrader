package com.piriurna.pokepockettrader.data.user.repositories

import com.piriurna.pokepockettrader.data.user.daos.UserDao
import com.piriurna.pokepockettrader.data.user.entities.UserEntity
import com.piriurna.pokepockettrader.domain.user.models.User
import com.piriurna.pokepockettrader.domain.user.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
): UserRepository {
    override suspend fun getUserById(nickname: String): User? {
        return userDao.selectUserById(nickname)?.let {
            User(
                nickname = it.nickname,
                friendNumber = it.friendNumber,
                email = it.email
            )
        }
    }

    override suspend fun insertNewUser(user: User) {
        userDao.insertNewUser(
            UserEntity(
                nickname = user.nickname,
                email = user.email,
                friendNumber = user.friendNumber
            )
        )
    }
}