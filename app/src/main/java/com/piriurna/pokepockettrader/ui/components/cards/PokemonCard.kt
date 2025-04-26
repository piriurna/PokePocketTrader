package com.piriurna.pokepockettrader.ui.components.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.piriurna.pokepockettrader.R
import com.piriurna.pokepockettrader.domain.models.Pokemon

@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    pokemon: Pokemon
) {
    Box(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier,
            model = pokemon.cardImageUrl,
            contentDescription = "pokemon_card",
            fallback = painterResource(R.drawable.dummy_pokemon_card),
            error = painterResource(R.drawable.dummy_pokemon_card),
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
        )
    }
}


@Preview
@Composable
private fun PokemonCardPreview() {
    PokemonCard(
        pokemon = Pokemon.dummyPokemonList.first()
    )

}