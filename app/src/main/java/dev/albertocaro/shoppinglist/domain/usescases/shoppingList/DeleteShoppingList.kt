package dev.albertocaro.shoppinglist.domain.usescases.shoppingList

import dev.albertocaro.shoppinglist.data.ShoppingListRepository
import dev.albertocaro.shoppinglist.domain.models.ShoppingList
import javax.inject.Inject

class DeleteShoppingList @Inject constructor(
    private val repository: ShoppingListRepository
){

    suspend operator fun invoke(list: ShoppingList) {
        repository.delete(list)
    }
}