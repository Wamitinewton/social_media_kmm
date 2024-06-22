package com.example.kmmsocial.android.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmmsocial.android.R
import com.example.kmmsocial.android.SocialAppTheme
import com.example.kmmsocial.android.common.components.CustomTextField
import com.example.kmmsocial.android.common.theming.ButtonHeight
import com.example.kmmsocial.android.common.theming.ExtraLargeSpacing
import com.example.kmmsocial.android.common.theming.LargeSpacing
import com.example.kmmsocial.android.common.theming.MediumSpacing


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                color = if (isSystemInDarkTheme()) {
                    MaterialTheme.colors.background
                } else {
                    MaterialTheme.colors.surface
                }
            )
            .padding(
                top = ExtraLargeSpacing + LargeSpacing,
                start = LargeSpacing + MediumSpacing,
                end = LargeSpacing + MediumSpacing,
                bottom = LargeSpacing
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(LargeSpacing)
    ) {
        CustomTextField(
            value = uiState.email,
            onValueChange = onEmailChange,
            hint = R.string.email_hint,
            keyboardType = KeyboardType.Email

        )
        CustomTextField(
            value = uiState.password,
            onValueChange = onPasswordChange,
            hint = R.string.password_hint,
            isPasswordTextField = true,
            keyboardType = KeyboardType.Password
        )

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(ButtonHeight),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            ),
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(text = stringResource(id = R.string.login_button_label))
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    SocialAppTheme {
        LoginScreen(uiState = LoginUiState(), onEmailChange = {}) {

        }
    }
}