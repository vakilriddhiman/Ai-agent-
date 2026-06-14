package com.example.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val md_theme_dark_primary = Color(0xFFD0BCFF)
val md_theme_dark_onPrimary = Color(0xFF3C0091)
val md_theme_dark_primaryContainer = Color(0xFFA078FF)
val md_theme_dark_onPrimaryContainer = Color(0xFF340080)
val md_theme_dark_secondary = Color(0xFF4CD7F6)
val md_theme_dark_onSecondary = Color(0xFF003640)
val md_theme_dark_secondaryContainer = Color(0xFF03B5D3)
val md_theme_dark_onSecondaryContainer = Color(0xFF00424E)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF0B1326)
val md_theme_dark_onBackground = Color(0xFFDAE2FD)
val md_theme_dark_surface = Color(0xFF0B1326)
val md_theme_dark_onSurface = Color(0xFFDAE2FD)
val md_theme_dark_surfaceVariant = Color(0xFF2D3449)
val md_theme_dark_onSurfaceVariant = Color(0xFFCBC3D7)
val md_theme_dark_outline = Color(0xFF958EA0)
val md_theme_dark_inverseOnSurface = Color(0xFF283044)
val md_theme_dark_inverseSurface = Color(0xFFDAE2FD)
val md_theme_dark_inversePrimary = Color(0xFF6D3BD7)
val md_theme_dark_surfaceTint = Color(0xFFD0BCFF)

private val DarkColorScheme =
  darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
  )

@Composable
fun MyApplicationTheme(
  content: @Composable () -> Unit,
) {
  MaterialTheme(colorScheme = DarkColorScheme, typography = Typography, content = content)
}
