package dev.albertocaro.shoppinglist.domain.usescases.auth

import dev.albertocaro.shoppinglist.data.AuthRepository
import javax.inject.Inject

class GetApiToken @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): String? {
         return repository.getToken()
    }
}