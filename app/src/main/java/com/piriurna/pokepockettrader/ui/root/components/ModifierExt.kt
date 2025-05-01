package com.piriurna.pokepockettrader.ui.root.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection

fun Modifier.applyWhen(condition: Boolean, modifier: Modifier.() -> Modifier): Modifier {
    return if(condition) {
        this.then(modifier())
    } else {
        this
    }
}


fun PaddingValues.plus(other: PaddingValues, layoutDirection: LayoutDirection): PaddingValues {
    return PaddingValues(
        top = other.calculateTopPadding() + this.calculateTopPadding(),
        bottom = other.calculateBottomPadding() + this.calculateBottomPadding(),
        start = other.calculateStartPadding(layoutDirection) + this.calculateStartPadding(layoutDirection),
        end = other.calculateEndPadding(layoutDirection) + this.calculateEndPadding(layoutDirection)
    )
}