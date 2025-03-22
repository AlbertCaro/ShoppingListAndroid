package dev.albertocaro.shoppinglist.ui.screen.auth

import androidx.compose.foundation.layout.Box
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

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { 
            NavigationBar { 
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Default.ShoppingCart,
                            contentDescription = "Shopping Lists"
                        )
                    },
                    selected = true,
                    onClick = {  }
                )

                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = "Shopping Lists"
                        )
                    },
                    selected = false,
                    onClick = {  }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Home")
        }
    }
}