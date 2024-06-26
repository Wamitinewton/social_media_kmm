package com.example.kmmsocial.android.auth.signup

import androidx.compose.runtime.Composable
import com.example.kmmsocial.android.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel


@Destination()
@Composable
 fun SignUp(
    navigator: DestinationsNavigator
) {
    val viewModel: SignUpViewModel = koinViewModel()
    SignUpScreen(
        uiState = viewModel.uiState,
        onUserNameChange = viewModel::updateUsername,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onNavigateToLogin = {

        },
        onNavigateToHome = {
                           navigator.navigate(HomeScreenDestination)
        },
        onSignUpClick = viewModel::signUp
    )

}