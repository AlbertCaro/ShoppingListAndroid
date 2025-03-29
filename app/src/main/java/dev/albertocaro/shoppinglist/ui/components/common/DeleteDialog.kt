package dev.albertocaro.shoppinglist.ui.components.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun DeleteDialog(imageVector: ImageVector, title: String, onConfirm: () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    IconButton(onClick = {
        showDialog = true
    }) {
        Icon(imageVector, contentDescription = "", tint = Color.Red)
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(title) },
            text = { Text("Esta acción es irreversible y no se puede deshacer.") },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm()
                        showDialog = false
                    }
                ) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}