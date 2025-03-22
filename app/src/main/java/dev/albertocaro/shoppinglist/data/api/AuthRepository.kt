package dev.albertocaro.shoppinglist.data.api

import android.util.Log
import dev.albertocaro.shoppinglist.data.api.services.AuthApiService
import dev.albertocaro.shoppinglist.domain.models.LoginData
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: AuthApiService
){

    fun login(loginData: LoginData) = flow {
        try {
            val tokenResponse = apiService.login(loginData)
            Log.d("TOKEN", tokenResponse.token)

            emit(true)
        } catch (e: HttpException) {
            if (e.code() == 401) emit(false)
            throw e
        }
    }
}