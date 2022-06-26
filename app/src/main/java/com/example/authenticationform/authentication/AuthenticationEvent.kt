package com.example.authenticationform.authentication

sealed class AuthenticationEvent {
    object ToggleAuthenticationMode: AuthenticationEvent()
}