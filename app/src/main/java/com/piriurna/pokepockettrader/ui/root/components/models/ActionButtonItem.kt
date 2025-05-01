package com.piriurna.pokepockettrader.ui.root.components.models

data class ActionButtonItem(
    val text: String,
    val onClick: () -> Unit
){
}