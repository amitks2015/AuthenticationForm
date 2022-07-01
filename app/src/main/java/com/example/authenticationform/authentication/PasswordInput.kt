package com.example.authenticationform.authentication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.authenticationform.R

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String?,
    onPasswordChanged: (String) -> Unit,
    onDoneClicked: () -> Unit,
) {
    var isPasswordHidden by remember { mutableStateOf(true) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = password.orEmpty(),
        onValueChange = onPasswordChanged,
        label = {
            Text(text = stringResource(id = R.string.label_password))
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable(
                    onClickLabel = if(isPasswordHidden) {
                        stringResource(id = R.string.cd_show_password)
                    } else {
                        stringResource(id = R.string.cd_hide_password)
                    }
                ) {
                    isPasswordHidden = !isPasswordHidden
                },
                imageVector = if(isPasswordHidden)
                    Icons.Default.Visibility
                else
                    Icons.Default.VisibilityOff,
                contentDescription = null
            )
        },
        visualTransformation = if(isPasswordHidden) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onDoneClicked()
            }
        )
    )
}