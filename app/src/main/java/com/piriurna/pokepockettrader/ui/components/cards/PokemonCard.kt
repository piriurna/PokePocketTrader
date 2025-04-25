package com.piriurna.pokepockettrader.ui.components.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.piriurna.pokepockettrader.domain.models.Pokemon

@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    pokemon: Pokemon
) {
    Box(
        modifier = modifier.size(200.dp),
    ) {
        AsyncImage(
            modifier = Modifier,
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemon.cardImageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "pokemon_card",
        )
    }
}