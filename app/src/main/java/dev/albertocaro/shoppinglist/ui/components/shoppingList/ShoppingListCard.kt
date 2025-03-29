package dev.albertocaro.shoppinglist.ui.components.shoppingList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.PlaylistRemove
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.albertocaro.shoppinglist.domain.models.ShoppingList
import dev.albertocaro.shoppinglist.ui.components.common.DeleteDialog
import dev.albertocaro.shoppinglist.ui.navigation.app.AppRoutes
import dev.albertocaro.shoppinglist.ui.navigation.app.LocalAppNavController
import dev.albertocaro.shoppinglist.ui.screen.shoppingList.ShoppingListViewModel

@Composable
@Preview
fun ShoppingListCard(
    shoppingList: ShoppingList = ShoppingList(1, "Ejemplo"),
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    val appNavController = LocalAppNavController.current

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
                val route = AppRoutes.createShoppingListDetailRoute(shoppingList.id!!)

                appNavController.navigate(route)
            }) {
                Icon(
                    Icons.AutoMirrored.Default.List,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 16.dp)
                )

                Column {
                    Text(shoppingList.name, style = MaterialTheme.typography.bodyLarge)
                    Text(
                        shoppingList.createdAt.toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            DeleteDialog(
                Icons.Default.PlaylistRemove,
                "¿Desea eliminar la lista \"${shoppingList.name}\"?"
            ) {
                viewModel.delete(shoppingList)
            }
        }
    }
}

