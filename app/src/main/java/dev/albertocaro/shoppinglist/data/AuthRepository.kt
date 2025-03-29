package dev.albertocaro.shoppinglist.data

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.albertocaro.shoppinglist.data.api.services.AuthApiService
import dev.albertocaro.shoppinglist.data.datastore.AuthDataStore
import dev.albertocaro.shoppinglist.domain.models.LoginData
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: AuthApiService,
    @ApplicationContext private val context: Context
){

    fun login(loginData: LoginData) = flow {
        try {
            val tokenResponse = apiService.login(loginData)
            AuthDataStore.saveToken(context, tokenResponse.token)

            Log.d("TOKEN", tokenResponse.token)

            emit(true)
        } catch (e: HttpException) {
            if (e.code() == 401) emit(false)
            throw e
        }
    }

    suspend fun loggedIn(): Boolean {
        return !getToken().isNullOrBlank()
    }

    suspend fun getToken(): String? {
        return AuthDataStore.getToken(context)
    }

    suspend fun logout() {
        AuthDataStore.clearToken(context)
    }
}