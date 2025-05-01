package com.piriurna.pokepockettrader

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.piriurna.pokepockettrader.domain.root.navigation.BottomBarItem
import com.piriurna.pokepockettrader.ui.root.components.PTScaffold
import com.piriurna.pokepockettrader.ui.root.navigation.RootNavigationGraph
import com.piriurna.pokepockettrader.ui.root.theme.PokePocketTraderTheme
import com.piriurna.pokepockettrader.ui.root.theme.Primary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(Color.argb(Primary.alpha,Primary.red, Primary.green, Primary.blue), Color.TRANSPARENT)
        )
        setContent {
            val navController = rememberNavController()
            PokePocketTraderTheme {
                PTScaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBarItems = BottomBarItem.dummyItems,
                    navController = navController
                ) { innerPadding ->
                    RootNavigationGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokePocketTraderTheme {
        Greeting("Android")
    }
}