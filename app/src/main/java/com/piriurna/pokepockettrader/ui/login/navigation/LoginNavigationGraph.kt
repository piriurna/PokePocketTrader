package com.piriurna.pokepockettrader.ui.login.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.piriurna.pokepockettrader.ui.root.navigation.models.Graph
import com.piriurna.pokepockettrader.ui.login.LoginScreen

@Composable
fun LoginNavigationGraph(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.LOGIN_GRAPH,
        startDestination = LoginDestinationScreen.Login.route
    ) {
        composable(route = LoginDestinationScreen.Login.route) {
            LoginScreen(modifier = modifier, navController = navController)
        }
    }
}

sealed class LoginDestinationScreen(val route: String) {
    object Login : LoginDestinationScreen(route = "login")
    object Register: LoginDestinationScreen(route = "register")
}