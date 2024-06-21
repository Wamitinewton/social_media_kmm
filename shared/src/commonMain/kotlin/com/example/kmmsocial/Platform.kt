package com.example.kmmsocial

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform