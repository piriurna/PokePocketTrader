package com.piriurna.pokepockettrader.domain.root.navigation

import com.piriurna.pokepockettrader.R

data class BottomBarItem(
    val route : String,
    val iconRes : Int,
    val title : String,
    val color : Int = 0x00000000
){

    companion object {
        val dummyItems = listOf(
            BottomBarItem(
                route = "POKEDEX",
                title = "Pokedex",
                iconRes = R.drawable.ic_pokedex
            ),
            BottomBarItem(
                route = "PROFILE",
                title = "Profile",
                iconRes = R.drawable.ic_profile
            )
        )
    }
}