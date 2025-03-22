package dev.albertocaro.shoppinglist.data.api.models

import com.google.gson.annotations.SerializedName

data class TokenReponse(
    @SerializedName("token") val token: String,
    @SerializedName("message") val message: String,
)