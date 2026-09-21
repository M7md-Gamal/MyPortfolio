package com.elkabsh.myportfolio.ui.theme

import androidx.compose.ui.graphics.Color

// Foundation - Warm charcoal background & surface hierarchy
val DarkBackground = Color(0xFF1A1614)
val DarkSurface = Color(0xFF252017)
val DarkSurfaceVariant = Color(0xFF302A1F)

// Primary Accent - Warm gold/bronze for premium identity
val GoldPrimary = Color(0xFFD4A574)
val GoldDark = Color(0xFFB8956A)

// Secondary Accent - Warm cream for subtle highlights
val WarmCream = Color(0xFFE8DCC8)

// Semantic Accents
val AccentRed = Color(0xFFEF4444)
val AccentBlue = Color(0xFF3B82F6)
val AccentEmerald = Color(0xFF10B981)
val AccentAmber = Color(0xFFF59E0B)
val AccentPurple = Color(0xFF8B5CF6)
val AccentIndigo = Color(0xFF6366F1)
val AccentRose = Color(0xFFF43F5E)

// Text - Warm whites & neutrals for maximum readability
val TextPrimary = Color(0xFFF5F0EB)
val TextSecondary = Color(0xFFA89B8C)
val TextMuted = Color(0xFF6B5E52)

// Borders & Dividers
val BorderColor = Color(0xFF3D3428)

// Compatibility aliases during migration
@Deprecated("Use GoldPrimary instead", ReplaceWith("GoldPrimary"))
val Blue = GoldPrimary

@Deprecated("Use GoldDark instead", ReplaceWith("GoldDark"))
val BlueDark = GoldDark

@Deprecated("Use WarmCream instead", ReplaceWith("WarmCream"))
val Green = WarmCream

@Deprecated("Use AccentRed instead", ReplaceWith("AccentRed"))
val Orange = AccentRed

@Deprecated("Use AccentBlue instead", ReplaceWith("AccentBlue"))
val Purple = AccentBlue

@Deprecated("Use AccentEmerald instead", ReplaceWith("AccentEmerald"))
val Yellow = AccentEmerald

@Deprecated("Use AccentRose instead", ReplaceWith("AccentRose"))
val Rose = AccentRose
