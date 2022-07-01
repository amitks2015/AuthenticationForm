package com.example.authenticationform.authentication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authenticationform.AuthenticationViewModel
import com.example.authenticationform.ui.theme.AuthenticationFormTheme

@Composable
fun Authentication() {
    val viewModel: AuthenticationViewModel = viewModel()
    AuthenticationFormTheme {
        AuthenticationContent(
            modifier = Modifier.fillMaxWidth(),
            authenticationState = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent
        )
    }
}

@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if(authenticationState.isLoading) {
            CircularProgressIndicator()
        } else {
            AuthenticationForm(
                modifier = Modifier.fillMaxSize(),
                authenticationMode =authenticationState.authenticationMode,
                email = authenticationState.email,
                password = authenticationState.password,
                onEmailChanged = { email ->
                    handleEvent(AuthenticationEvent.EmailChanged(email))
                },
                onPasswordChanged = { password ->
                    handleEvent(AuthenticationEvent.PasswordChanged(password))
                },
                onAuthenticate = {
                    handleEvent(AuthenticationEvent.Authenticate)
                }
            )
        }
    }
}