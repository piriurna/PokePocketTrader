package com.piriurna.pokepockettrader.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.domain.pokemon.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
): ViewModel() {

    private val _pokemonList: MutableStateFlow<List<Pokemon>> = MutableStateFlow(emptyList())
    val pokemonList: Flow<List<Pokemon>> = _pokemonList


    init {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemonList.emit(getPokemonListUseCase())
        }
    }
}