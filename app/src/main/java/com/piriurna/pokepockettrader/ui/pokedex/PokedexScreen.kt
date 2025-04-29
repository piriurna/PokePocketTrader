package com.piriurna.pokepockettrader.ui.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon
import com.piriurna.pokepockettrader.ui.pokemon.components.cards.PokemonCard
import java.nio.file.WatchEvent

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
    onCardClicked: (Pokemon, PokemonActionType) -> Unit
) {
    val isEditing = remember {
        mutableStateOf(false)
    }

    val actionType = remember {
        mutableStateOf<PokemonActionType?>(null)
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                modifier = Modifier.padding(horizontal = 12.dp),
                columns = GridCells.FixedSize(120.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(uiState.pokemonList) {
                    PokemonCard(
                        modifier = Modifier
                            .clickable(
                                enabled = actionType.value != null,
                                onClick = {
                                    onCardClicked(it, actionType.value!!)
                                }
                            ),
                        pokemon = it,
                        cardHeight = 170.dp
                    )
                }
            }
        }

        if(isEditing.value) {
            Box(Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))
                .clickable(enabled = false) {}
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            if(isEditing.value) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = Color.Red)
                        .size(35.dp)
                        .clickable() {
                            actionType.value = PokemonActionType.REMOVE
                            isEditing.value = false
                        },
                    contentAlignment = Alignment.Center

                ) {
                    Text("-", color = Color.White, fontWeight = FontWeight(600), fontSize = 30.sp)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = Color.Green)
                        .size(35.dp)
                        .clickable() {
                            actionType.value = PokemonActionType.ADD
                            isEditing.value = false
                        },
                    contentAlignment = Alignment.Center

                ) {
                    Icon(Icons.Default.Add, contentDescription = "", tint = Color.White)
                }

            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = Color.Gray)
                    .size(50.dp)
                    .clickable { isEditing.value = !isEditing.value },
                contentAlignment = Alignment.Center

            ) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "",
                    tint = Color.White
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
        onCardClicked = { _, _ -> }
    )
}