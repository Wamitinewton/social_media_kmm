package com.example.kmmsocial.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.kmmsocial.android.common.theming.DarkColors
import com.example.kmmsocial.android.common.theming.LightColors
import com.example.kmmsocial.android.common.theming.Shapes
import com.example.kmmsocial.android.common.theming.Typography

@Composable
fun SocialAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        typography = Typography,
            content = content
    )
}