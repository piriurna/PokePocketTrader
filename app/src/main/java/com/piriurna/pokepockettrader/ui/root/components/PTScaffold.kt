package com.piriurna.pokepockettrader.ui.root.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.piriurna.pokepockettrader.domain.root.navigation.BottomBarItem
import com.piriurna.pokepockettrader.ui.root.theme.PokePocketTraderTheme

@Composable
fun PTScaffold(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    bottomBarItems: List<BottomBarItem>,
    navController: NavHostController? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    val topBarHeight = 52.dp + WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val bottomBarHeight = 52.dp + WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val currentNavDestination = navController?.currentBackStackEntryAsState()?.value
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ){
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            content = {
                content(it.plus(WindowInsets.statusBars.asPaddingValues(), LayoutDirection.Ltr))
            },
        )

        PTActionBar(
            modifier = Modifier
                .align(Alignment.TopCenter),
            actionBarHeight = topBarHeight,
            statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
        )


        PTBottomBar(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            bottomBarItems = bottomBarItems,
            selectedRoute = currentNavDestination?.destination?.route?:"",
            onItemSelected = { navController?.navigate(it.route) },
            bottomBarHeight = bottomBarHeight,
            navigationBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
        )
    }
}

@Preview
@Composable
private fun PTScaffoldPreview() {
    PokePocketTraderTheme {
        PTScaffold(
            isLoading = false,
            bottomBarItems = BottomBarItem.dummyItems,

        ) {
            Text(modifier = Modifier.padding(it), text = "Scaffold test")
        }
    }
}