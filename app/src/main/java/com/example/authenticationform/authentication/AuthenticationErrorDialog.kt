package com.example.authenticationform.authentication

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.authenticationform.R

@Composable
fun AuthenticationErrorDialog(
    modifier: Modifier = Modifier,
    error: String,
    onDismissError: () -> Unit
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissError,
        confirmButton = {
            TextButton(onClick =onDismissError) {
                Text(text = stringResource(id = R.string.ok))
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.error_title)
            )
        },
        text = {
            Text(text = error)
        }
    )
}