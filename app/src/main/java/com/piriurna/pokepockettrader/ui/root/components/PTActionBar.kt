package com.piriurna.pokepockettrader.ui.root.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PTActionBar(
    modifier: Modifier = Modifier,
    actionBarHeight: Dp,
    statusBarHeight: Dp = 0.dp
) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .height(actionBarHeight)
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(top = statusBarHeight),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("PokePocketTrader", style = MaterialTheme.typography.titleMedium, color = Color.White)
    }
}