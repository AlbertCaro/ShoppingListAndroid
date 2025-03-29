package dev.albertocaro.shoppinglist.ui.screen.shoppingList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingListDetail(id: Long) {
    Scaffold { padding ->
        Box(modifier = Modifier.padding(padding).padding(horizontal = 16.dp)) {
            Text("Detail $id")
        }
    }
}