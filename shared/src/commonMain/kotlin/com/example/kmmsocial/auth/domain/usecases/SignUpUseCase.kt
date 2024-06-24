package com.example.kmmsocial.auth.domain.usecases

import com.example.kmmsocial.auth.domain.model.AuthResultData
import com.example.kmmsocial.auth.domain.repository.AuthRepository
import com.example.kmmsocial.common.util.Result
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignUpUseCase: KoinComponent {
    private val repository: AuthRepository by inject()

    suspend operator fun invoke(
        email: String,
        name: String,
        password:String
    ): Result<AuthResultData>{
        if (name.isBlank() || name.length < 3){
            return Result.Error(
                message = "Invalid name"
            )
        }
        if (email.isBlank() || "@" !in email){
            return Result.Error(
                message = "Invalid email"
            )
        }
        if (password.isBlank() || password.length < 4){
            return Result.Error(
                message = "invalid password or too short"
            )
        }
        return repository.signUp(name, email, password)
    }
}