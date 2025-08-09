package com.example.pulsetask.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFF00C2A8)
val PrimaryVariant = Color(0xFF7C4DFF)
val Accent = Color(0xFFFF6B6B)
val SurfaceLight = Color(0xFFFFFFFF)
val SurfaceDark = Color(0xFF0F1720)
val MutedGray = Color(0xFF9AA4B2)
val Completed = Color(0xFF34D399)

private val LightColors = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    surface = SurfaceLight,
    onSurface = Color(0xFF111827),
    secondary = Color(0xFF7C4DFF),
    tertiary = Color(0xFF9AA4B2)
)

@Composable
fun PulseTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}
