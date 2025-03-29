package dev.albertocaro.shoppinglist.data.api.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ShoppingListResponse(
    @SerializedName("id") val id: Long? = null,

    @SerializedName("name") val name: String,

    @SerializedName("createdAt") val createdAt: Date,

    @SerializedName("items") val items: List<ListItemResponse>,
)
