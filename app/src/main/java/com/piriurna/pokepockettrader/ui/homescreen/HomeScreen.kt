package com.piriurna.pokepockettrader.ui.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.piriurna.pokepockettrader.ui.components.cards.PokemonCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel
) {
    val pokemonList = homeViewModel.pokemonList.collectAsState(initial = emptyList())
    Column(modifier = modifier.fillMaxSize()) {
        LazyVerticalGrid(columns = GridCells.Fixed(10)) {
            items(pokemonList.value) {
                PokemonCard(pokemon = it)
            }
        }
    }
}