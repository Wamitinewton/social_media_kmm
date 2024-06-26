package com.example.kmmsocial.android

import android.app.Application
import com.example.kmmsocial.android.di.appModule
import com.example.kmmsocial.di.getSharedmodules
import org.koin.core.context.startKoin

class SocialApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedmodules())
        }
    }
}