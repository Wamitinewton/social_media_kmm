package com.example.kmmsocial.di

import com.example.kmmsocial.auth.data.AuthService
import com.example.kmmsocial.auth.domain.repository.AuthRepository
import com.example.kmmsocial.auth.domain.repository.AuthRepositoryImpl
import com.example.kmmsocial.auth.domain.usecases.SignInUseCase
import com.example.kmmsocial.auth.domain.usecases.SignUpUseCase
import com.example.kmmsocial.common.util.providedispatcher
import org.koin.dsl.module

private val authmodule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    factory { AuthService() }
    factory { SignUpUseCase() }
    factory { SignInUseCase() }
}

private val utilityModule = module {
    factory { providedispatcher() }
}

fun getSharedmodules() = listOf(authmodule, utilityModule)