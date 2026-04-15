package com.adso.senaaccess.ui.theme


import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Esquema para MODO OSCURO
private val DarkColorScheme = darkColorScheme(
    primary = GreenSenaDark,      // Verde pastel para resaltar
    secondary = GreenAccent,
    tertiary = GreenLight,
    background = DarkBackground,
    surface = DarkSurface,
    onPrimary = DarkBackground,   // Texto oscuro sobre el verde claro
    onBackground = Color.White,
    onSurface = Color.White
)

// Esquema para MODO CLARO (Tu estilo principal)
private val LightColorScheme = lightColorScheme(
    primary = GreenSena,          // Verde base
    secondary = GreenDark,
    tertiary = GreenAccent,
    background = BackgroundGray,  // Fondo limpio
    surface = SurfaceWhite,       // Tarjetas e inputs
    onPrimary = TextOnGreen,      // Texto blanco sobre botones verdes
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Selección dinámica de colores según el sistema
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current

    // Sincronización de la barra de estado del sistema (StatusBar)
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window

            // La barra de estado se pinta del color primario (Verde)
            window.statusBarColor = colorScheme.primary.toArgb()

            // Ajusta los iconos (batería, hora) para que se vean bien
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Asegúrate de tener el archivo Typography.kt
        content = content
    )
}