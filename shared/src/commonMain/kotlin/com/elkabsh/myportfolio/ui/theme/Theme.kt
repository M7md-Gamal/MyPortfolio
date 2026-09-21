package com.elkabsh.myportfolio.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = GoldPrimary,
    onPrimary = TextPrimary,
    primaryContainer = GoldDark,
    onPrimaryContainer = TextPrimary,
    secondary = WarmCream,
    onSecondary = DarkBackground,
    secondaryContainer = WarmCream,
    onSecondaryContainer = DarkBackground,
    tertiary = AccentRed,
    onTertiary = DarkBackground,
    tertiaryContainer = AccentRed,
    onTertiaryContainer = DarkBackground,
    background = DarkBackground,
    onBackground = TextPrimary,
    surface = DarkSurface,
    onSurface = TextPrimary,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = BorderColor,
    outlineVariant = BorderColor,
    error = AccentRose,
    onError = TextPrimary
)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = PortfolioTypography,
        content = content
    )
}
