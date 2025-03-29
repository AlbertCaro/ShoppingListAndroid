package dev.albertocaro.shoppinglist.data.api.services

import dev.albertocaro.shoppinglist.data.api.models.ShoppingListRequest
import dev.albertocaro.shoppinglist.data.api.models.ShoppingListResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ShoppingListApiService {
    @GET("/shopping_lists/{id}")
    suspend fun getOne(@Path("id") id: Long): ShoppingListResponse

    @PUT("/shopping_lists/{id}")
    suspend fun edit(@Path("id") id: Long, @Body body: ShoppingListRequest): ShoppingListResponse

    @DELETE("/shopping_lists/{id}")
    suspend fun delete(@Path("id") id: Long)

    @GET("/shopping_lists")
    suspend fun getAll(): List<ShoppingListResponse>

    @POST("/shopping_lists")
    suspend fun save(@Body body: ShoppingListRequest): List<ShoppingListResponse>
}