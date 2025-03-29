package dev.albertocaro.shoppinglist.domain.models

import dev.albertocaro.shoppinglist.data.api.models.ProductResponse

data class Product(
    val id: Long,
    val name: String,
)

fun ProductResponse.toDomain() = Product(id, name)
