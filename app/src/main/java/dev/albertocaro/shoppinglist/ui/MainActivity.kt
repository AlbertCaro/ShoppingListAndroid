package dev.albertocaro.shoppinglist.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import dev.albertocaro.shoppinglist.ui.navigation.app.AppNavHost
import dev.albertocaro.shoppinglist.ui.theme.ShoppingListAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingListAppTheme {
                AppNavHost()
            }
        }
    }
}