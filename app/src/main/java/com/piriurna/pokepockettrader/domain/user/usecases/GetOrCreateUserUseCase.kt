package com.piriurna.pokepockettrader.domain.user.usecases

import com.piriurna.pokepockettrader.domain.user.LoggedUser
import com.piriurna.pokepockettrader.domain.user.models.User
import com.piriurna.pokepockettrader.domain.user.repositories.UserRepository
import javax.inject.Inject
import kotlin.math.log

class GetOrCreateUserUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val loggedUser: LoggedUser
) {


    suspend operator fun invoke(nickname: String): User {
        val localUser = userRepository.getUserById(nickname)

        if(localUser == null) {
            userRepository.insertNewUser(User(nickname = nickname, email = "", friendNumber = ""))
        }

        loggedUser.login(nickname)
        return userRepository.getUserById(nickname)!!
    }
}