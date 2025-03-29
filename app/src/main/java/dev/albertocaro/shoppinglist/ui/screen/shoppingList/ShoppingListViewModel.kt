package dev.albertocaro.shoppinglist.ui.screen.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.albertocaro.shoppinglist.domain.models.ShoppingList
import dev.albertocaro.shoppinglist.domain.usescases.shoppingList.DeleteShoppingList
import dev.albertocaro.shoppinglist.domain.usescases.shoppingList.GetAllShoppingLists
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val getAllShoppingLists: GetAllShoppingLists,
    private val deleteShoppingList: DeleteShoppingList,
) : ViewModel() {

    private val _listUiState = MutableStateFlow<ListUiState>(ListUiState.Loading)
    val listUiState = _listUiState as StateFlow<ListUiState>

    fun fetchAll() {
        viewModelScope.launch {
            getAllShoppingLists()
                .catch { _listUiState.value = ListUiState.Error(it.message.orEmpty(), it) }
                .flowOn(Dispatchers.IO)
                .collect { list ->
                    _listUiState.value = ListUiState.Success(list)
                }
        }
    }

    fun delete(list: ShoppingList) {
        viewModelScope.launch {
            deleteShoppingList(list)

            fetchAll()
        }
    }
}

sealed class ListUiState {
    data object Loading : ListUiState()

    data class Error(val message: String, val error: Throwable) : ListUiState()

    data class Success(val list: List<ShoppingList>) : ListUiState()
}