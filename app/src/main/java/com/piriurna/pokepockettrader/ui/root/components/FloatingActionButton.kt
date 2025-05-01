package com.piriurna.pokepockettrader.ui.root.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FloatingActionButton(
    modifier: Modifier = Modifier,
    isActionButtonActive: Boolean,
    onActionButtonClicked: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .applyWhen(isActionButtonActive) {
                this
                    .background(Color.Black.copy(alpha = 0.2f))
                    .clickable(enabled = false) {}

            }
            .padding(bottom = 52.dp)
            .padding(12.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        if(isActionButtonActive) {
            ActionButtonAction(
                actionText = "-",
                onActionClicked = {},
                actionColor = Color.Red,
                actionTextColor = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            ActionButtonAction(
                actionText = "+",
                onActionClicked = {},
                actionColor = Color.Green,
                actionTextColor = Color.White
            )

        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = Color.Gray)
                .size(50.dp)
                .clickable(onClick = onActionButtonClicked),
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


@Composable
fun ActionButtonAction(
    modifier: Modifier = Modifier,
    actionText: String,
    actionColor: Color,
    actionTextColor: Color,
    actionSize: Dp = 35.dp,
    onActionClicked: () -> Unit,
    actionTextStyle: TextStyle = TextStyle(fontSize = 30.sp, fontWeight = FontWeight(600))
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color = actionColor)
            .size(actionSize)
            .clickable(onClick = onActionClicked),
        contentAlignment = Alignment.Center

    ) {
        Text(actionText, color = actionTextColor, style = actionTextStyle)
    }
}