package dev.albertocaro.shoppinglist.ui.navigation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.albertocaro.shoppinglist.ui.screen.home.ProductScreen
import dev.albertocaro.shoppinglist.ui.screen.home.ShoppingListScreen

@Composable
fun HomeNavHost(
    navHostController: NavHostController = rememberNavController(),
    modifier: Modifier
 ) {

    NavHost(
        navController = navHostController,
        startDestination = HomeRoutes.SHOPPING_LIST_SCREEN,
        modifier = modifier
    ) {
        composable(HomeRoutes.SHOPPING_LIST_SCREEN) {
            ShoppingListScreen()
        }
        composable(HomeRoutes.PRODUCT_SCREEN) {
            ProductScreen()
        }
    }
}