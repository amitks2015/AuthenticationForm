package com.example.authenticationform.authentication

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.authenticationform.R

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    email: String?,
    onEmailChanged: (String) -> Unit
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = email.orEmpty(),
        onValueChange = onEmailChanged,
        label = {
            Text(text = stringResource(id = R.string.label_email))
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}