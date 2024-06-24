package com.example.kmmsocial.auth.domain.repository

import com.example.kmmsocial.auth.domain.model.AuthResultData
import com.example.kmmsocial.common.util.Result

internal interface AuthRepository {

    suspend fun signUp(
        name:String,
        email:String,
        password:String
    ): Result<AuthResultData>

    suspend fun signIn(email: String, password: String): Result<AuthResultData>
}