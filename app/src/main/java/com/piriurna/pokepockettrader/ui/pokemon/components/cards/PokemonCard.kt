package com.piriurna.pokepockettrader.ui.pokemon.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.piriurna.pokepockettrader.R
import com.piriurna.pokepockettrader.domain.pokemon.models.Pokemon

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
    cardWidth: Dp = 120.dp,
    cardHeight: Dp = 170.dp
) {
    Column(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier
                .width(cardWidth)
                .height(cardHeight),
            model = pokemon.cardImageUrl,
            contentDescription = "pokemon_card",
            fallback = painterResource(R.drawable.dummy_pokemon_card),
            error = painterResource(R.drawable.dummy_pokemon_card),
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix()
                    .apply {
                        setToSaturation(if(pokemon.owned) 1f else 0f) }
            )
        )

        Spacer(Modifier.height(4.dp))

        FlowRow(
            modifier = Modifier
                .width(cardWidth)
        ) {
            Box(
                Modifier
                    .padding(start = 6.dp, bottom = 6.dp)
                    .clip(RoundedCornerShape(
                        topStart = 0f,
                        bottomStart = 10f,
                        topEnd = 10f,
                        bottomEnd = 0f
                    ))
                    .background(
                        color = Color.DarkGray,
                    )
                    .height(14.dp)
                    .width(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("1", color = Color.White, fontSize = 10.sp)
            }

            if(pokemon.wishlisted)
                Box(
                    Modifier
                        .padding(start = 6.dp, bottom = 6.dp)
                        .clip(RoundedCornerShape(
                            topStart = 0f,
                            bottomStart = 10f,
                            topEnd = 10f,
                            bottomEnd = 0f
                        ))
                        .background(
                            color = Color(0xFF34C759),
                        )
                        .height(14.dp)
                        .padding(horizontal = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Wishlist", color = Color.White, fontSize = 10.sp)
                }
        }
    }
}


@Preview
@Composable
private fun OwnedPokemonCardPreview() {
    PokemonCard(
        pokemon = Pokemon.dummyPokemonList.first().copy(wishlisted = true)
    )

}

@Preview
@Composable
private fun NotOwnedPokemonCardPreview() {
    PokemonCard(
        pokemon = Pokemon.dummyPokemonList.first().copy(owned = false)
    )

}