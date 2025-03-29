package dev.albertocaro.shoppinglist.domain.usescases.shoppingList

import dev.albertocaro.shoppinglist.data.ShoppingListRepository
import dev.albertocaro.shoppinglist.domain.models.ShoppingList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllShoppingLists @Inject constructor(
    private val repository: ShoppingListRepository
) {

    operator fun invoke(): Flow<List<ShoppingList>> {
        return repository.fetchAll()
    }
}