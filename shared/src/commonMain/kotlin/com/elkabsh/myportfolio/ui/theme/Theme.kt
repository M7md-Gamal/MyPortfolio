package com.elkabsh.myportfolio.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    onPrimary = TextPrimary,
    primaryContainer = BlueDark,
    onPrimaryContainer = TextPrimary,
    secondary = Green,
    onSecondary = DarkBackground,
    secondaryContainer = Green,
    onSecondaryContainer = DarkBackground,
    tertiary = Orange,
    onTertiary = DarkBackground,
    tertiaryContainer = Orange,
    onTertiaryContainer = DarkBackground,
    background = DarkBackground,
    onBackground = TextPrimary,
    surface = DarkSurface,
    onSurface = TextPrimary,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = BorderColor,
    outlineVariant = BorderColor
)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = PortfolioTypography,
        content = content
    )
}
