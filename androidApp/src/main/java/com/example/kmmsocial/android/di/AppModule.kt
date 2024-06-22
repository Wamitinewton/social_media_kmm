package com.example.kmmsocial.android.di

import com.example.kmmsocial.android.auth.login.LoginVIewModel
import com.example.kmmsocial.android.auth.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginVIewModel() }
    viewModel { SignUpViewModel() }
}