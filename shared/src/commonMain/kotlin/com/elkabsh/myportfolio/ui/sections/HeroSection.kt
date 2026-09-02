package com.elkabsh.myportfolio.ui.sections

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.PortfolioData
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun HeroSection(
    data: PortfolioData,
    isMobile: Boolean,
    onNavigateTo: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val horizontalPadding = if (isMobile) 24.dp else 80.dp
    val verticalPadding = if (isMobile) 64.dp else 120.dp

    // Animation states
    val infiniteTransition = rememberInfiniteTransition(label = "hero")
    val animationProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "pulse"
    )

    // Staggered reveal animations
    val greetingAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(600, delayMillis = 100),
        label = "greeting"
    )
    val greetingOffset by animateIntAsState(
        targetValue = 0,
        animationSpec = tween(600, delayMillis = 100, easing = FastOutSlowInEasing),
        label = "greetingOffset"
    )

    val nameAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(600, delayMillis = 300),
        label = "name"
    )
    val nameOffset by animateIntAsState(
        targetValue = 0,
        animationSpec = tween(600, delayMillis = 300, easing = FastOutSlowInEasing),
        label = "nameOffset"
    )

    val titleAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(600, delayMillis = 500),
        label = "title"
    )
    val titleOffset by animateIntAsState(
        targetValue = 0,
        animationSpec = tween(600, delayMillis = 500, easing = FastOutSlowInEasing),
        label = "titleOffset"
    )

    val taglineAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(600, delayMillis = 700),
        label = "tagline"
    )

    val locationAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(600, delayMillis = 900),
        label = "location"
    )

    val buttonsAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(600, delayMillis = 1100),
        label = "buttons"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    colors = listOf(
                        DarkBackground,
                        DarkSurface,
                        DarkBackground
                    )
                )
            )
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Greeting with animation
            Text(
                text = "Hello, I'm",
                style = MaterialTheme.typography.headlineMedium,
                color = TextSecondary,
                modifier = Modifier
                    .alpha(greetingAlpha)
                    .offset(y = greetingOffset.dp)
            )

            // Name with animation
            Text(
                text = data.name,
                style = if (isMobile) MaterialTheme.typography.displayMedium else MaterialTheme.typography.displayLarge,
                color = TextPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .alpha(nameAlpha)
                    .offset(y = nameOffset.dp)
            )

            // Title with animation
            Text(
                text = data.title,
                style = if (isMobile) MaterialTheme.typography.headlineLarge else MaterialTheme.typography.displayMedium,
                color = Blue,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .alpha(titleAlpha)
                    .offset(y = titleOffset.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Tagline with animation
            Text(
                text = data.tagline,
                style = MaterialTheme.typography.bodyLarge,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(if (isMobile) 1f else 0.6f)
                    .alpha(taglineAlpha)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Location with animation
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = TextMuted,
                    modifier = Modifier.alpha(locationAlpha)
                )
                Text(
                    text = data.location,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextMuted,
                    modifier = Modifier.alpha(locationAlpha)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Buttons with animation
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.alpha(buttonsAlpha)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Blue)
                        .clickable { onNavigateTo(3) }
                        .padding(horizontal = 32.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = "View Projects",
                        style = MaterialTheme.typography.labelLarge,
                        color = TextPrimary
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(DarkSurfaceVariant)
                        .clickable { onNavigateTo(4) }
                        .padding(horizontal = 32.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = "Contact Me",
                        style = MaterialTheme.typography.labelLarge,
                        color = TextPrimary
                    )
                }
            }
        }
    }
}
