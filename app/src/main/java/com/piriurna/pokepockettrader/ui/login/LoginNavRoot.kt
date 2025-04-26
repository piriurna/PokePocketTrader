package com.piriurna.pokepockettrader.ui.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.piriurna.pokepockettrader.ui.login.navigation.LoginNavigationGraph

@Composable
fun LoginNavRoot(modifier: Modifier = Modifier, navController: NavHostController) {
    Scaffold { innerPadding ->
        LoginNavigationGraph(modifier.padding(innerPadding), navController = navController)
    }

}