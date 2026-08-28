package com.elkabsh.myportfolio.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

/**
 * Wraps content with a fade-in + slide-up animation triggered by scroll position.
 * The section fades in and slides up when it enters the viewport.
 */
@Composable
fun FadeInOnScrollSection(
    scrollState: ScrollState,
    sectionOffset: Int,
    viewportHeight: Int,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val progress = remember(sectionOffset, scrollState.value, viewportHeight) {
        if (viewportHeight <= 0) 1f
        else {
            val visibleDistance = sectionOffset - scrollState.value
            val triggerPoint = viewportHeight * 0.85f
            when {
                visibleDistance > triggerPoint -> 0f
                visibleDistance < 0 -> 1f
                else -> 1f - (visibleDistance / triggerPoint)
            }
        }
    }

    val animatedAlpha = animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
    )

    val animatedTranslationY = animateFloatAsState(
        targetValue = if (progress > 0f) 0f else 40f,
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
    )

    Box(
        modifier = modifier
            .graphicsLayer {
                alpha = animatedAlpha.value
                translationY = animatedTranslationY.value
            },
        content = content
    )
}
