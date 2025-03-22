package dev.albertocaro.shoppinglist.ui.navigation.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.albertocaro.shoppinglist.ui.screen.auth.HomeScreen
import dev.albertocaro.shoppinglist.ui.screen.auth.LoginScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    CompositionLocalProvider(LocalAppNavController provides navController) {
        NavHost(navController = navController, startDestination = AppRoutes.LOGIN) {
            composable(AppRoutes.LOGIN) {
                LoginScreen()
            }

            composable(AppRoutes.HOME) {
                HomeScreen()
            }
        }
    }
}