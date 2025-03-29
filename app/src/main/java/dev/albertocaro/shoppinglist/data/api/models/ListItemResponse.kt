package dev.albertocaro.shoppinglist.data.api.models

import com.google.gson.annotations.SerializedName

data class ListItemResponse(
    @SerializedName("id") val id: Long? = null,

    @SerializedName("bought") val bought: Boolean = false,

    @SerializedName("quantity") val quantity: Int,

    @SerializedName("product") val product: ProductResponse,
)
