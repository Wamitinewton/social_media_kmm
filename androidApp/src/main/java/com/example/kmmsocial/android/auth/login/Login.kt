package com.example.kmmsocial.android.auth.login

import androidx.compose.runtime.Composable

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Composable
fun Login(
    navigator: DestinationsNavigator
) {
    val viewModel: LoginVIewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.loginUiState,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword
    )
}