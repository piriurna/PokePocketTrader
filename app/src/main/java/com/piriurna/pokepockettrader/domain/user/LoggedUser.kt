package com.piriurna.pokepockettrader.domain.user

import com.piriurna.pokepockettrader.domain.user.models.User

interface LoggedUser {

    fun login(nickname: String)

    fun logOut()

    fun getLoggedInNickname(): String?
}