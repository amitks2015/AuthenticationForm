package com.example.authenticationform

import androidx.lifecycle.ViewModel
import com.example.authenticationform.authentication.AuthenticationEvent
import com.example.authenticationform.authentication.AuthenticationMode
import com.example.authenticationform.authentication.AuthenticationState
import kotlinx.coroutines.flow.MutableStateFlow

class AuthenticationViewModel: ViewModel() {

    private val uiState = MutableStateFlow(AuthenticationState())

    fun handleEvent(event: AuthenticationEvent) {
        when(event) {
            is AuthenticationEvent.ToggleAuthenticationMode -> {
                toggleAuthenticationMode()
            }
        }
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