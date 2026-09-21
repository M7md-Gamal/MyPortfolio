package com.elkabsh.myportfolio.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

/**
 * Wraps content with a fade-in + slide-up animation triggered by scroll position.
 * Once triggered, the section smoothly reveals and stays anchored.
 */
@Composable
fun FadeInOnScrollSection(
    scrollState: ScrollState,
    sectionOffset: Int,
    viewportHeight: Int,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    var hasAppeared by remember { mutableStateOf(false) }

    // Check if section is within the reveal trigger zone
    if (!hasAppeared) {
        if (viewportHeight <= 0 || sectionOffset == 0) {
            hasAppeared = true
        } else {
            val visibleDistance = sectionOffset - scrollState.value
            val triggerPoint = viewportHeight * 0.90f
            if (visibleDistance <= triggerPoint) {
                hasAppeared = true
            }
        }
    }

    val animatedAlpha by animateFloatAsState(
        targetValue = if (hasAppeared) 1f else 0f,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
        label = "sectionAlpha"
    )

    val animatedTranslationY by animateFloatAsState(
        targetValue = if (hasAppeared) 0f else 32f,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
        label = "sectionTranslationY"
    )

    Box(
        modifier = modifier
            .graphicsLayer {
                alpha = animatedAlpha
                translationY = animatedTranslationY
            },
        content = content
    )
}
