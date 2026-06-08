package com.jorgeromo.androidbasicsclass.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val GameTrackerDarkColorScheme = darkColorScheme(
    primary = Color(0xFF7C4DFF),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF3D1F8A),
    onPrimaryContainer = Color(0xFFE8DEFF),
    secondary = Color(0xFF03DAC6),
    onSecondary = Color(0xFF000000),
    secondaryContainer = Color(0xFF005047),
    onSecondaryContainer = Color(0xFF70EFDE),
    tertiary = Color(0xFFFF6D00),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFF5C2500),
    onTertiaryContainer = Color(0xFFFFDBCC),
    background = Color(0xFF0D0D0D),
    onBackground = Color(0xFFE6E1E5),
    surface = Color(0xFF1A1A2E),
    onSurface = Color(0xFFE6E1E5),
    surfaceVariant = Color(0xFF1F1F3A),
    onSurfaceVariant = Color(0xFFCAC4D0),
    outline = Color(0xFF938F99),
    error = Color(0xFFCF6679),
    onError = Color(0xFF000000)
)

@Composable
fun AndroidBasicsClassTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color(0xFF0D0D0D).toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = GameTrackerDarkColorScheme,
        typography = Typography,
        content = content
    )
}