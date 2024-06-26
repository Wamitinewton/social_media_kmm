package com.example.kmmsocial.android.auth.login

import androidx.compose.runtime.Composable
import com.example.kmmsocial.android.destinations.HomeScreenDestination
import com.example.kmmsocial.android.destinations.SignUpDestination
import com.ramcosta.composedestinations.annotation.Destination

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination(start = true)
@Composable
fun Login(
    navigator: DestinationsNavigator
) {
    val viewModel: LoginVIewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.loginUiState,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onSignInClick = viewModel::signIn,
        onNavigateToHome = {
            navigator.navigate(HomeScreenDestination) {
                popUpTo(HomeScreenDestination.route) { inclusive = true }
            }
        },
        onNavigateToSignup = {
            navigator.navigate(SignUpDestination) {
                popUpTo(SignUpDestination.route) {
                    inclusive = true
                }
            }
        }
    )
}