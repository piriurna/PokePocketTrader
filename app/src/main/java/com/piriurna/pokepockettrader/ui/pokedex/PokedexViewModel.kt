package com.piriurna.pokepockettrader.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.domain.pokemon.usecases.GetPokemonListUseCase
import com.piriurna.pokepockettrader.domain.user.LoggedUser
import com.piriurna.pokepockettrader.ui.root.BaseViewModel
import com.piriurna.pokepockettrader.ui.root.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


data class PokedexUiState(
    val isLoading: Boolean = false,
    val pokemonList: List<Pokemon> = emptyList()
): UiState


@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val loggedUser: LoggedUser
): BaseViewModel<PokedexUiState>() {
    override fun initialValue(): PokedexUiState = PokedexUiState()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(initialValue().copy(isLoading = true))

            loggedUser.getLoggedInNickname()?.let {
                getPokemonListUseCase(it).collect { pokemonList ->
                    updateState(
                        uiState.value.copy(
                            isLoading = false,
                            pokemonList = pokemonList
                        )
                    )
                }
            }
        }
    }
}