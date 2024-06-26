package com.example.kmmsocial.android.auth.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.kmmsocial.android.common.theming.SmallSpacint


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToHome: () -> Unit,
    onSignInClick: () -> Unit,
    onNavigateToSignup: () -> Unit
) {
    val context = LocalContext.current
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
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

            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(size = 16.dp))

            ) {
                Image(
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = null
                )
            }

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
                    onSignInClick()
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
            GoToSignup(modifier) {
                onNavigateToSignup()
            }
        }
        if (uiState.isAuthenticating) {
            CircularProgressIndicator()
        }
    }

    LaunchedEffect(
        key1 = uiState.authenticationSucces,
        key2 = uiState.authErrorMessage,
        block = {
            if (uiState.authenticationSucces) {
                onNavigateToHome()
            }
            if (uiState.authErrorMessage != null) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    )
}

@Composable
fun GoToSignup(
    modifier: Modifier = Modifier,
    onNavigateToSignup: () -> Unit
) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.spacedBy(
            SmallSpacint
        )
    ) {
        Text(text = "Don't have an account?", style = MaterialTheme.typography.caption)
        Text(
            text = "SignUp",
            style = MaterialTheme.typography.caption,
            color = Color.Blue,
            modifier = modifier.clickable { onNavigateToSignup() }
        )
    }
    
}

@Preview
@Composable
private fun LoginScreenPreview() {
    SocialAppTheme {
        LoginScreen(
            uiState = LoginUiState(),
            onEmailChange = {},
            onPasswordChange = {},
            onNavigateToHome = {},
            onSignInClick = {},
            onNavigateToSignup = {},
        )
    }
}