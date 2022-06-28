package com.example.authenticationform.authentication

sealed class AuthenticationEvent {
    object Authenticate: AuthenticationEvent()
    data class EmailChanged(val email: String): AuthenticationEvent()
    object ErrorDismissed: AuthenticationEvent()
    data class PasswordChanged(val password: String): AuthenticationEvent()
    object ToggleAuthenticationMode: AuthenticationEvent()
}