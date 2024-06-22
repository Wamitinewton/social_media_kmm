package com.example.kmmsocial.android.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginVIewModel: ViewModel() {
    var loginUiState by mutableStateOf(LoginUiState())
    private set

    fun updateEmail(input: String){
        loginUiState = loginUiState.copy(email = input)
    }
    fun updatePassword(input: String){
        loginUiState = loginUiState.copy(password = input)
    }
}

data class LoginUiState(
    var email: String = "",
    var password: String = ""
)