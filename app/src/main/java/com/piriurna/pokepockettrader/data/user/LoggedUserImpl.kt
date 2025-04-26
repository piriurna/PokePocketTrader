package com.piriurna.pokepockettrader.data.user

import com.piriurna.pokepockettrader.domain.user.LoggedUser
import com.piriurna.pokepockettrader.domain.user.models.User

class LoggedUserImpl: LoggedUser {

    var loggedInUser: User? = null

    override fun login(nickname: String) {
       loggedInUser = User(
           nickname = nickname,
           email = "",
           friendNumber = ""
       )
    }

    override fun logOut() {
        loggedInUser = null
    }

    override fun getLoggedInNickname(): String? {
        return loggedInUser?.nickname
    }
}