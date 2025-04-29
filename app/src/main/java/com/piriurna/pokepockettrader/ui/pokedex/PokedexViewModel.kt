package com.piriurna.pokepockettrader.ui.pokedex

import androidx.lifecycle.viewModelScope
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.domain.pokemon.usecases.AddCardToCurrentUserUseCase
import com.piriurna.pokepockettrader.domain.pokemon.usecases.GetPokemonListUseCase
import com.piriurna.pokepockettrader.domain.pokemon.usecases.RemoveCardToCurrentUserUseCase
import com.piriurna.pokepockettrader.domain.root.Resource
import com.piriurna.pokepockettrader.ui.root.BaseViewModel
import com.piriurna.pokepockettrader.ui.root.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


data class PokedexUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val pokemonList: List<Pokemon> = emptyList()
): UiState


@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val addCardToCurrentUserUseCase: AddCardToCurrentUserUseCase,
    private val removeCardToCurrentUserUseCase: RemoveCardToCurrentUserUseCase,
): BaseViewModel<PokedexUiState>() {
    override fun initialValue(): PokedexUiState = PokedexUiState()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getPokemonListUseCase().collect { result ->
                updateState(
                    result,
                    onSuccess = { pokemonList ->
                        updateState(
                            uiState.value.copy(
                                isLoading = false,
                                pokemonList = pokemonList
                            )
                        )
                    }
                )
            }
        }
    }

    fun onCardClicked(pokemon: Pokemon, action: PokemonActionType) {
        viewModelScope.launch(Dispatchers.IO) {
            when(action) {
                PokemonActionType.ADD -> addCardToCurrentUserUseCase(pokemon).collect {
                    updateState(it, onSuccess = {})
                }

                PokemonActionType.REMOVE -> removeCardToCurrentUserUseCase(pokemon).collect {
                    updateState(it, onSuccess = {})
                }
            }

        }
    }


    private fun <T> updateState(
        resource: Resource<T>,
        onSuccess: (T) -> Unit
    ) {
        when(resource) {
            is Resource.Success -> {
                onSuccess(resource.data!!)
            }

            is Resource.Loading -> updateState(
                uiState.value.copy(
                    isLoading = true
                )
            )

            is Resource.Error -> {
                updateState(
                    uiState.value.copy(
                        isLoading = false,
                        error = resource.message
                    )
                )
            }
        }
    }
}