package dev.albertocaro.shoppinglist.data

import dev.albertocaro.shoppinglist.data.api.services.ShoppingListApiService
import dev.albertocaro.shoppinglist.domain.models.ShoppingList
import dev.albertocaro.shoppinglist.domain.models.toDomain
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShoppingListRepository @Inject constructor(
    private val apiService: ShoppingListApiService
) {

    fun fetchAll() = flow {
        val lists = apiService.getAll().map { it.toDomain() }

        emit(lists)
    }

    suspend fun delete(list: ShoppingList) {
        apiService.delete(list.id!!)
    }
}