package dev.albertocaro.shoppinglist.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.albertocaro.shoppinglist.ui.components.common.ListErrorMessage
import dev.albertocaro.shoppinglist.ui.components.home.HomeTopBar
import dev.albertocaro.shoppinglist.ui.components.shoppingList.ShoppingListCard
import dev.albertocaro.shoppinglist.ui.navigation.app.AppRoutes
import dev.albertocaro.shoppinglist.ui.navigation.app.LocalAppNavController
import dev.albertocaro.shoppinglist.ui.screen.shoppingList.ListUiState
import dev.albertocaro.shoppinglist.ui.screen.shoppingList.ShoppingListViewModel
import retrofit2.HttpException

@Composable
@Preview
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    val uiState by viewModel.listUiState.collectAsState()

    Scaffold(
        topBar = {
            HomeTopBar("Listas de compra")
        }
    ) { innerPadding ->
        when (val state = uiState) {
            is ListUiState.Error -> {
                ListErrorMessage(state.error, state.message, innerPadding)
            }

            ListUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    CircularProgressIndicator()
                }
            }

            is ListUiState.Success -> {
                if (state.list.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Text("No hay listas registradas")
                    }
                } else {
                    LazyColumn(
                        contentPadding = innerPadding,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxSize()
                    ) {
                        items(state.list) { list -> ShoppingListCard(list) }
                    }
                }
            }
        }

        LaunchedEffect(Unit) {
            viewModel.fetchAll()
        }
    }
}