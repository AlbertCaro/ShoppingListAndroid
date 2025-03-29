package dev.albertocaro.shoppinglist.domain.models

import dev.albertocaro.shoppinglist.data.api.models.ShoppingListResponse
import java.util.Date

data class ShoppingList(
    val id: Long?,
    val name: String,
    val createdAt: Date = Date(),
    val items: List<ShoppingListItem> = emptyList()
)

fun ShoppingListResponse.toDomain() = ShoppingList(id!!, name, createdAt, items.map { it.toDomain() })
