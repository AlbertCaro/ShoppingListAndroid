package dev.albertocaro.shoppinglist.domain.models

import dev.albertocaro.shoppinglist.data.api.models.ListItemResponse

data class ShoppingListItem(
    val id: Long,
    val quantity: Int,
    val bought: Boolean,
    val product: Product,
)

fun ListItemResponse.toDomain() = ShoppingListItem(id!!, quantity, bought, product.toDomain())
