package com.piriurna.pokepockettrader.ui.root.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.piriurna.pokepockettrader.domain.root.navigation.BottomBarItem
import com.piriurna.pokepockettrader.ui.root.theme.PokePocketTraderTheme
import com.piriurna.pokepockettrader.ui.root.theme.TextSecondary

@Composable
fun PTBottomBar(
    modifier: Modifier = Modifier,
    bottomBarItems: List<BottomBarItem>,
    onItemSelected: (BottomBarItem) -> Unit,
    selectedRoute: String,
    bottomBarHeight: Dp = 56.dp,
    navigationBarHeight: Dp = 0.dp
) {
    Row(
        modifier = modifier
            .height(bottomBarHeight)
            .padding(bottom = navigationBarHeight)
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        bottomBarItems.forEachIndexed { index, item ->
            PTBottomBarItem(
                modifier = Modifier
                    .weight(1f),
                bottomBarItem = item,
                isSelected = selectedRoute == item.route,
                onItemSelected = onItemSelected
            )

            if (index < bottomBarItems.lastIndex)
                VerticalDivider(
                    Modifier
                        .height(26.dp)
                        .padding(vertical = 8.dp)
                )
        }
    }
}

@Composable
fun PTBottomBarItem(
    modifier: Modifier = Modifier,
    bottomBarItem: BottomBarItem,
    isSelected: Boolean,
    onItemSelected: (BottomBarItem) -> Unit
) {
    val selectedColor = MaterialTheme.colorScheme.primary
    val unselectedColor = TextSecondary
    val iconTint = if (isSelected) selectedColor else unselectedColor
    val textTint = iconTint

    Column(
        modifier = modifier
            .clickable(onClick = { onItemSelected(bottomBarItem) })
            .padding(vertical = 6.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(bottomBarItem.iconRes),
            contentDescription = bottomBarItem.title,
            tint = iconTint
        )

        if (isSelected) {
            Text(
                text = bottomBarItem.title,
                color = textTint,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview
@Composable
private fun PTBottomBarPreview() {
    PokePocketTraderTheme {
        PTBottomBar(
            bottomBarItems = BottomBarItem.dummyItems,
            selectedRoute = "PROFILE",
            onItemSelected = {},
        )
    }
}