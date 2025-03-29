package dev.albertocaro.shoppinglist.ui.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.albertocaro.shoppinglist.ui.navigation.app.AppRoutes
import dev.albertocaro.shoppinglist.ui.navigation.app.LocalAppNavController
import dev.albertocaro.shoppinglist.ui.screen.auth.AuthViewModel
import retrofit2.HttpException

@Composable
fun ListErrorMessage(
    error: Throwable,
    message: String,
    innerPadding: PaddingValues,
    viewModel: AuthViewModel = hiltViewModel()
) {
    if (error is HttpException && error.code() == 403) {
        val appNavController = LocalAppNavController.current

        viewModel.logout()

        appNavController.navigate(AppRoutes.LOGIN) {
            popUpTo(0) { inclusive = false }
            launchSingleTop = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Text("Error: $message")
    }
}