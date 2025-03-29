package dev.albertocaro.shoppinglist.ui.navigation.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.albertocaro.shoppinglist.ui.screen.auth.AuthViewModel
import dev.albertocaro.shoppinglist.ui.screen.auth.HomeScreen
import dev.albertocaro.shoppinglist.ui.screen.auth.LoginScreen
import dev.albertocaro.shoppinglist.ui.screen.shoppingList.ShoppingListDetail

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    viewModel: AuthViewModel = hiltViewModel()
) {
    val isAuthenticated = viewModel.isAuthenticated()

    val startDestination = if(isAuthenticated) AppRoutes.HOME else AppRoutes.LOGIN

    CompositionLocalProvider(LocalAppNavController provides navController) {
        NavHost(navController = navController, startDestination = startDestination) {
            composable(AppRoutes.LOGIN) {
                LoginScreen()
            }

            composable(AppRoutes.HOME) {
                HomeScreen()
            }

            composable(AppRoutes.SHOPPING_LIST_DETAIL, arguments = listOf(
                navArgument("id") { type = NavType.LongType }
            )) { stackEntry ->
                val id = stackEntry.arguments?.getLong("id") ?: 0

                ShoppingListDetail(id)
            }
        }
    }
}