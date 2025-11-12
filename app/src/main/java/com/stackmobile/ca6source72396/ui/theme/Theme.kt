package com.stackmobile.ca6source72396.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

import androidx.compose.ui.graphics.Color
private val LightColors = lightColorScheme(
    primary = md_theme_primary,
    onPrimary = md_theme_onPrimary,
    background = md_theme_background,
    onBackground = md_theme_onBackground
)

private val DarkColors = darkColorScheme(
    primary = md_theme_primary,
    onPrimary = md_theme_onPrimary,
    background = Color(0xFF121212),
    onBackground = Color(0xFFEAEAEA)
)

@Composable
fun Ca6source72396Theme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,     // <-- use o Typography que já existe no seu Type.kt
        content = content
    )
}

