package dev.albertocaro.shoppinglist.ui.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.albertocaro.shoppinglist.ui.navigation.app.LocalAppNavController

@Composable
@Preview
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }

    val loginState by viewModel.uiState.collectAsState()

    val appNavController = LocalAppNavController.current

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(32.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Iniciar sesión",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                label = {
                    Text("Usuario")
                },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { username = it }
            )

            OutlinedTextField(
                value = password,
                label = {
                    Text("Contraseña")
                },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { password = it },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon =
                        if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility

                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(icon, contentDescription = "")
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.logIn(username, password)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ingresar")
            }
        }
    }

    LaunchedEffect(loginState) {
        when (val state = loginState) {
            is LoginUiState.Error -> {
                snackbarHostState.showSnackbar(state.message)
            }
            LoginUiState.Initial -> {}
            is LoginUiState.Success -> {
                if (state.result) {
                    snackbarHostState.showSnackbar("Bienvenido!")

                    return@LaunchedEffect
                }

                snackbarHostState.showSnackbar("Usuario y contraseña incorrectos")
            }
        }
    }
}