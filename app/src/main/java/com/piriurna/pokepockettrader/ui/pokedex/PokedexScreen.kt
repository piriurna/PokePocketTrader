package com.piriurna.pokepockettrader.ui.pokedex

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.ui.pokemon.components.cards.PokemonCard
import com.piriurna.pokepockettrader.ui.root.components.FloatingActionButton

@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val viewModel = hiltViewModel<PokedexViewModel>()
    val uiState = viewModel.uiState.value
    PokedexScreenContent(
        modifier,
        uiState,
        navController,
        viewModel::onCardClicked
    )
}

@Composable
private fun PokedexScreenContent(
    modifier: Modifier = Modifier,
    uiState: PokedexUiState,
    navController: NavController = rememberNavController(),
    onCardClicked: (Pokemon) -> Unit
) {
    val isEditing = remember {
        mutableStateOf(false)
    }

    val actionType = remember {
        mutableStateOf<PokemonActionType?>(null)
    }

    Box(modifier = modifier.fillMaxSize()) {
        PokemonGridList(
            pokemonList = uiState.pokemonList,
            isClickEnabled = actionType.value != null,
            onCardClicked = onCardClicked
        )

        FloatingActionButton(
            isActionButtonActive = isEditing.value,
            onActionButtonClicked = { isEditing.value = !isEditing.value },
        )
    }
}

@Composable
private fun PokemonGridList(
    modifier: Modifier = Modifier,
    isClickEnabled: Boolean,
    pokemonList: List<Pokemon>,
    onCardClicked: (Pokemon) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 12.dp),
            columns = GridCells.FixedSize(120.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(pokemonList) {
                PokemonCard(
                    modifier = Modifier
                        .clickable(
                            enabled = isClickEnabled,
                            onClick = {
                                onCardClicked(it)
                            }
                        ),
                    pokemon = it,
                    cardHeight = 170.dp
                )
            }
        }
    }
}


@Preview(showBackground = true, device = "id:pixel_8",)
@Composable
private fun PokedexScreenPreview() {
    PokedexScreenContent(
        uiState = PokedexUiState(pokemonList = Pokemon.dummyPokemonList),
        onCardClicked = { _ -> }
    )
}