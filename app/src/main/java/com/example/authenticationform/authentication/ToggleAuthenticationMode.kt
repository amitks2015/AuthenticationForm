package com.example.authenticationform.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.authenticationform.R

@Composable
fun ToggleAuthenticationMode(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    onToggleAuthenticationMode: () -> Unit,
) {
    Surface(
        modifier = modifier.padding(top = 16.dp),
        shadowElevation = 8.dp
    ) {
        TextButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp),
            onClick = onToggleAuthenticationMode
        ) {
            Text(
                text = if(authenticationMode == AuthenticationMode.SIGN_IN) {
                    stringResource(id = R.string.action_need_account)
                } else {
                    stringResource(id = R.string.action_already_have_account)
                }
            )
        }
    }
}