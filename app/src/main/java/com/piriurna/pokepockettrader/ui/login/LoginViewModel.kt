package com.piriurna.pokepockettrader.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piriurna.pokepockettrader.domain.user.models.User
import com.piriurna.pokepockettrader.domain.user.usecases.GetOrCreateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getOrCreateUserUseCase: GetOrCreateUserUseCase
): ViewModel() {

    private val _loggedUser: MutableStateFlow<User?> = MutableStateFlow(null)
    val loggedUser: Flow<User?> = _loggedUser

    fun onLoginClicked(nickname: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loggedUser.emit(getOrCreateUserUseCase(nickname))
        }
    }
}