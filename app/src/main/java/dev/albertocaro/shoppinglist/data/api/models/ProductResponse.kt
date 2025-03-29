package dev.albertocaro.shoppinglist.data.api.models

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
)
