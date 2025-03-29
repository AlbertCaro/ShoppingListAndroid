package dev.albertocaro.shoppinglist.ui.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.albertocaro.shoppinglist.domain.usescases.auth.LoggedIn
import dev.albertocaro.shoppinglist.domain.usescases.auth.Login
import dev.albertocaro.shoppinglist.domain.usescases.auth.Logout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val login: Login,
    private val loggedIn: LoggedIn,
    private val logoutUseCase: Logout,
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Initial)
    val uiState: StateFlow<LoginUiState> = _uiState

    fun logIn(username: String, password: String) {
        viewModelScope.launch {
            login(username, password)
                .catch { _uiState.value = LoginUiState.Error(it.message.orEmpty()) }
                .flowOn(Dispatchers.IO)
                .collect { result ->
                    _uiState.value = LoginUiState.Success(result)
                }
        }
    }

    fun isAuthenticated(): Boolean {
        val result = runBlocking {
            loggedIn()
        }

        return result
    }

    fun logout() {
        runBlocking {
            logoutUseCase()
        }
    }
}

sealed class LoginUiState {
    data object Initial : LoginUiState()
    data class Success(val result: Boolean) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}