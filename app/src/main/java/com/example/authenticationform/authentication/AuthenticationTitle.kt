package com.example.authenticationform.authentication

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.authenticationform.R
import com.example.authenticationform.ui.theme.AuthenticationFormTheme

@Composable
fun AuthenticationTitle(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode
) {
    val title = when(authenticationMode) {
        AuthenticationMode.SIGN_UP -> stringResource(id = R.string.title_sign_up)
        AuthenticationMode.SIGN_IN -> stringResource(id = R.string.title_sign_in)
    }
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
    )
}

@Preview
@Composable
fun PreviewAuthenticationTitle() {
    AuthenticationFormTheme {
        AuthenticationTitle(authenticationMode = AuthenticationMode.SIGN_IN)
    }
}