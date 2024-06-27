package com.example.kmmsocial.android.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.kmmsocial.android.MainActivityViewModel
import com.example.kmmsocial.android.auth.login.LoginVIewModel
import com.example.kmmsocial.android.auth.signup.SignUpViewModel
import com.example.kmmsocial.android.common.datastore.UserSettingsSerializer
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginVIewModel(get(), get()) }
    viewModel { SignUpViewModel(get(), get()) }
    viewModel { MainActivityViewModel(get()) }


    single {
        DataStoreFactory.create(
            serializer = UserSettingsSerializer,
            produceFile = {
                androidContext().dataStoreFile(
                    fileName = "app_user_settings"
                )
            }
        )
    }

    /*
    we use single to make sure that only one instance of this repo [database factory] is created
    if there is more than one instance of datastore within the same file: Datastore crashes due to conflicting keys
    if you intend to access datastore from more than one instance, you can use multi ton or MultiProcessingDataStoreFactory
    */
}