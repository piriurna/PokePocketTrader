package com.piriurna.pokepockettrader.domain.user.usecases

import com.piriurna.pokepockettrader.domain.user.models.User
import com.piriurna.pokepockettrader.domain.user.repositories.UserRepository
import javax.inject.Inject

class GetOrCreateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {


    suspend operator fun invoke(nickname: String): User {
        val localUser = userRepository.getUserById(nickname)

        if(localUser == null) {
            userRepository.insertNewUser(User(nickname = nickname, email = "", friendNumber = ""))
        }

        return userRepository.getUserById(nickname)!!
    }
}