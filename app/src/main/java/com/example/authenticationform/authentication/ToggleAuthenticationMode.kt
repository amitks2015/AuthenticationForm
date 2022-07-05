package com.example.authenticationform.authentication

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToggleAuthenticationMode(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(top = 16.dp),
        shadowElevation = 8.dp
    ) {
        TextButton(onClick = { /*TODO*/ }) {

        }
    }
}