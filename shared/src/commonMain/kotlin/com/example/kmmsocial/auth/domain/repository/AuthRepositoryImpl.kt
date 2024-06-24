package com.example.kmmsocial.auth.domain.repository

import com.example.kmmsocial.auth.data.AuthService
import com.example.kmmsocial.auth.data.SignInRequest
import com.example.kmmsocial.auth.data.SignUpRequest
import com.example.kmmsocial.auth.data.toAuthResultData
import com.example.kmmsocial.auth.domain.model.AuthResultData
import com.example.kmmsocial.common.util.DispatcherProvider
import com.example.kmmsocial.common.util.Result
import kotlinx.coroutines.withContext


internal class AuthRepositoryImpl(
    private val dispatcher: DispatcherProvider,
    private val authService: AuthService
) : AuthRepository {
    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Result<AuthResultData> {
        return withContext(dispatcher.io){
            try {
                val request = SignUpRequest(name, email, password)

                val authResponse = authService.signUp(request)

                if (authResponse.data == null){
                    Result.Error(
                        message = authResponse.errorMessage!!
                    )
                } else{
                    Result.Success(
                        data = authResponse.data.toAuthResultData()
                    )
                }
            }catch (e: Exception){
                Result.Error(
                    message = "We could not send your request, try again later"
                )
            }
        }
    }

    override suspend fun signIn(email: String, password: String): Result<AuthResultData> {
        return withContext(dispatcher.io){
           try {
               val request = SignInRequest(email, password)

               val authResponse = authService.signin(request)

               if (authResponse.data == null){
                   Result.Error(
                       message = authResponse.errorMessage!!
                   )
               } else{
                   Result.Success(
                       data = authResponse.data.toAuthResultData()
                   )
               }
           } catch (e: Exception){
               Result.Error(
                   message = "We could not process your request, try again later"
               )
           }
        }
    }
}