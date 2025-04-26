package com.piriurna.pokepockettrader.ui.pokedex

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.ui.pokemon.components.cards.PokemonCard

@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val viewModel = hiltViewModel<PokedexViewModel>()
    val pokemonList = viewModel.uiState.value.pokemonList
    PokedexScreenContent(modifier, pokemonList, navController)
}

@Composable
private fun PokedexScreenContent(
    modifier: Modifier = Modifier,
    pokemonList: List<Pokemon>,
    navController: NavController = rememberNavController()
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(125.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            items(pokemonList) {
                PokemonCard(
                    modifier = Modifier.padding(10.dp),
                    pokemon = it
                )
            }
        }
    }
}


@Preview(showBackground = true, device = "id:pixel_8",)
@Composable
private fun PokedexScreenPreview() {
    PokedexScreenContent(
        pokemonList = Pokemon.dummyPokemonList
    )
}