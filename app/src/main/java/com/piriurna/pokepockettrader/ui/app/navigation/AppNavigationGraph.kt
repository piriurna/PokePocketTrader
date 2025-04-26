package com.piriurna.pokepockettrader.ui.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.piriurna.pokepockettrader.ui.root.navigation.models.Graph
import com.piriurna.pokepockettrader.ui.pokedex.PokedexScreen

@Composable
fun AppNavigationGraph(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.APP_GRAPH,
        startDestination = AppDestinationScreen.Pokedex.route
    ) {
        composable(route = AppDestinationScreen.Pokedex.route) {
            PokedexScreen(modifier = modifier, navController = navController)
        }
    }
}

sealed class AppDestinationScreen(val route: String) {
    object Pokedex : AppDestinationScreen(route = "POKEDEX")
    object Collection: AppDestinationScreen(route = "COLLECTION")
}