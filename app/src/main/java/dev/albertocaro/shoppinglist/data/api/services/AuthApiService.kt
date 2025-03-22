package dev.albertocaro.shoppinglist.data.api.services

import dev.albertocaro.shoppinglist.data.api.models.TokenReponse
import dev.albertocaro.shoppinglist.domain.models.LoginData
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("/auth/login")
    suspend fun login(@Body loginData: LoginData): TokenReponse
}