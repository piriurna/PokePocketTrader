package com.piriurna.pokepockettrader.ui.root.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.piriurna.pokepockettrader.ui.app.navigation.AppNavigationGraph
import com.piriurna.pokepockettrader.ui.login.LoginNavRoot
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
        startDestination = RootDestinationScreen.App.route
    ) {
        composable(route = RootDestinationScreen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(route = RootDestinationScreen.App.route) {
            PokedexScreen(modifier = modifier, navController = navController)
        }
    }
}

sealed class RootDestinationScreen(val route: String) {
    object Login : RootDestinationScreen(route = "LOGIN")
    object App: RootDestinationScreen(route = "APP")
}