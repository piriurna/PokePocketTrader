package com.piriurna.pokepockettrader.ui.root.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.piriurna.pokepockettrader.ui.login.LoginScreen
import com.piriurna.pokepockettrader.ui.pokedex.PokedexScreen
import com.piriurna.pokepockettrader.ui.root.navigation.models.Graph

@Composable
fun RootNavigationGraph(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT_GRAPH,
        startDestination = RootDestinationScreen.Pokedex.route
    ) {
        composable(route = RootDestinationScreen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(route = RootDestinationScreen.Pokedex.route) {
            PokedexScreen(modifier = modifier, navController = navController)
        }
    }
}

sealed class RootDestinationScreen(val route: String) {
    object Login : RootDestinationScreen(route = "LOGIN")
    object Pokedex: RootDestinationScreen(route = "POKEDEX")
}