package com.example.authenticationform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authenticationform.authentication.AuthenticationEvent
import com.example.authenticationform.authentication.AuthenticationMode
import com.example.authenticationform.authentication.AuthenticationState
import com.example.authenticationform.authentication.PasswordRequirements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthenticationViewModel: ViewModel() {

    private val uiState = MutableStateFlow(AuthenticationState())

    fun handleEvent(event: AuthenticationEvent) {
        when(event) {
            is AuthenticationEvent.Authenticate -> {

            }
            is AuthenticationEvent.EmailChanged -> {
                updateEmail(event.email)
            }
            is AuthenticationEvent.PasswordChanged -> {
                updatePassword(event.password)
            }
            is AuthenticationEvent.ToggleAuthenticationMode -> {
                toggleAuthenticationMode()
            }
        }
    }

    private fun authenticate() {
        uiState.value = uiState.value.copy(isLoading = true)
        //Make network request
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            withContext(Dispatchers.Main) {
                uiState.value = uiState.value.copy(error = "Something went wrong")
            }
        }
    }

    private fun updateEmail(email: String) {
        uiState.value =  uiState.value.copy(email = email)
    }

    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()
        if(password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if(password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if(password.any {it.isDigit()}) {
            requirements.add(PasswordRequirements.NUMBER)
        }
        uiState.value =  uiState.value.copy(
            password = password,
            passwordRequirements = requirements
        )
    }

    private fun toggleAuthenticationMode() {
        val currentMode = uiState.value.authenticationMode
        val newMode = if(currentMode == AuthenticationMode.SIGN_IN) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.SIGN_IN
        }
        uiState.value = uiState.value.copy(authenticationMode = newMode)
    }
}