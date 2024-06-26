package com.example.kmmsocial.android.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmsocial.auth.domain.usecases.SignInUseCase
import com.example.kmmsocial.common.util.Result
import kotlinx.coroutines.launch

class LoginVIewModel(
    private val signInUseCase: SignInUseCase
): ViewModel() {
    var loginUiState by mutableStateOf(LoginUiState())
    private set


    fun signIn(){
       viewModelScope.launch {
           loginUiState = loginUiState.copy(isAuthenticating = true)
           val authResultData = signInUseCase(loginUiState.email, loginUiState.password)

           loginUiState = when(authResultData){
               is Result.Error -> {
                   loginUiState.copy(
                       isAuthenticating = false,
                       authErrorMessage = authResultData.message
                   )
               }
               is Result.Success -> {
                   loginUiState.copy(
                       isAuthenticating = false,
                       authenticationSucces = true
                   )
               }
           }
       }
    }

    fun updateEmail(input: String){
        loginUiState = loginUiState.copy(email = input)
    }
    fun updatePassword(input: String){
        loginUiState = loginUiState.copy(password = input)
    }
}

data class LoginUiState(
    var email: String = "",
    var password: String = "",
    var isAuthenticating: Boolean = false,
    var authErrorMessage: String? = null,
    var authenticationSucces:Boolean = false
)