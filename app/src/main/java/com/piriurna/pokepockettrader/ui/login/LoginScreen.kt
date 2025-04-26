package com.piriurna.pokepockettrader.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.piriurna.pokepockettrader.ui.root.navigation.RootDestinationScreen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val viewModel: LoginViewModel = hiltViewModel()

    val loggedUser = viewModel.uiState.value.loggedUser

    LaunchedEffect(loggedUser) {
        if(loggedUser != null)
            navController.navigate(RootDestinationScreen.App.route)
    }

    LoginScreenContent(
        modifier = modifier,
        onLogInClicked = viewModel::onLoginClicked
    )
}


@Composable
private fun LoginScreenContent(
    modifier: Modifier = Modifier,
    onLogInClicked: (String) -> Unit
) {
    val userTextField = rememberTextFieldState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BasicTextField(
                modifier = Modifier.background(Color.Gray),
                state = userTextField
            )

            Button(
                enabled = userTextField.text.isNotBlank(),
                onClick = { onLogInClicked(userTextField.text.toString()) },
            ) {
                Text("Login")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreenContent(onLogInClicked = {})
}