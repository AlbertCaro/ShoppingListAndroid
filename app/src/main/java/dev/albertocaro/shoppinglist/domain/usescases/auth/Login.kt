package dev.albertocaro.shoppinglist.domain.usescases.auth

import dev.albertocaro.shoppinglist.data.AuthRepository
import dev.albertocaro.shoppinglist.domain.models.LoginData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Login @Inject constructor(
    private val repository: AuthRepository
) {

    operator fun invoke(username: String, password: String): Flow<Boolean> {
        return repository.login(LoginData(username, password))
    }
}