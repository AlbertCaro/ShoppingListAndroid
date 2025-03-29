@file:OptIn(ExperimentalMaterial3Api::class)

package dev.albertocaro.shoppinglist.ui.components.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import dev.albertocaro.shoppinglist.ui.navigation.app.AppRoutes
import dev.albertocaro.shoppinglist.ui.navigation.app.LocalAppNavController
import dev.albertocaro.shoppinglist.ui.screen.auth.AuthViewModel

@Composable
fun HomeTopBar(
    title: String,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    var menuExpanded by remember { mutableStateOf(false) }

    val appNavController = LocalAppNavController.current

    TopAppBar(
        title = {
            Text(title)
        },

        actions = {
            IconButton(onClick = { menuExpanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Más opciones")
            }

            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false }
            ) {

                DropdownMenuItem(
                    text = { Text("Cerrar sesión") },
                    onClick = {
                        menuExpanded = false

                        authViewModel.logout()
                        appNavController.navigate(AppRoutes.LOGIN) {
                            popUpTo(0) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    )
}