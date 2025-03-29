package dev.albertocaro.shoppinglist.ui.screen.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.albertocaro.shoppinglist.ui.navigation.home.HomeNavHost
import dev.albertocaro.shoppinglist.ui.navigation.home.HomeRoutes

@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    val currentScreen = navController.currentBackStackEntryAsState().value?.destination?.route

    Column {
        Box(modifier = Modifier.weight(1f)) {
            HomeNavHost(
                navHostController = navController,
                modifier = Modifier
            )
        }

        NavigationBar {
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "Shopping Lists"
                    )
                },
                label = { Text("Listas de compra") },
                selected = currentScreen == HomeRoutes.SHOPPING_LIST_SCREEN,
                onClick = {
                    navController.navigate(HomeRoutes.SHOPPING_LIST_SCREEN)
                }
            )

            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Shopping Lists"
                    )
                },
                label = { Text("Productos") },
                selected = currentScreen == HomeRoutes.PRODUCT_SCREEN,
                onClick = {
                    navController.navigate(HomeRoutes.PRODUCT_SCREEN)
                }
            )
        }
    }
}