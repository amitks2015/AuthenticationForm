package com.example.authenticationform.authentication

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.authenticationform.R

@Composable
fun AuthenticationButton(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    enableAuthentication: Boolean,
    onAuthenticate: () -> Unit
) {
    Button(
        onClick = onAuthenticate,
        enabled = enableAuthentication
    ) {
        Text(
            text = if(authenticationMode == AuthenticationMode.SIGN_IN) {
                stringResource(id = R.string.label_sign_in)
            } else {
                stringResource(id = R.string.label_sign_up)
            }
        )
    }
}