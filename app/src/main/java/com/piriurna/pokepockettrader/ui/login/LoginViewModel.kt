package com.piriurna.pokepockettrader.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piriurna.pokepockettrader.domain.user.LoggedUser
import com.piriurna.pokepockettrader.domain.user.models.User
import com.piriurna.pokepockettrader.domain.user.usecases.GetOrCreateUserUseCase
import com.piriurna.pokepockettrader.ui.root.BaseViewModel
import com.piriurna.pokepockettrader.ui.root.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


data class LoginUiState(
    val isLoading: Boolean = false,
    val loggedUser: User? = null
): UiState

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getOrCreateUserUseCase: GetOrCreateUserUseCase
): BaseViewModel<LoginUiState>() {

    override fun initialValue() = LoginUiState()

    fun onLoginClicked(nickname: String) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(
                uiState.value.copy(
                    isLoading = false,
                    loggedUser = getOrCreateUserUseCase(nickname)
                )
            )
        }
    }
}