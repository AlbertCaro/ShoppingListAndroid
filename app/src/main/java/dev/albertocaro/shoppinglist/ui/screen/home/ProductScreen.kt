package dev.albertocaro.shoppinglist.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.albertocaro.shoppinglist.ui.components.home.HomeTopBar

@Composable
fun ProductScreen() {
    Scaffold(
        topBar = { HomeTopBar("Productos") }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text("Product")
        }
    }
}