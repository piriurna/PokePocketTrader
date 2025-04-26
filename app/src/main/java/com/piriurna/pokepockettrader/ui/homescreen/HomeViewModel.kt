package com.piriurna.pokepockettrader.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piriurna.pokepockettrader.domain.models.Pokemon
import com.piriurna.pokepockettrader.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
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