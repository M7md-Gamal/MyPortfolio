package com.elkabsh.myportfolio.ui.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val horizontalPadding = if (isMobile) 24.dp else 64.dp
    val verticalPadding = if (isMobile) 48.dp else 80.dp
    val nameSize = if (isMobile) MaterialTheme.typography.headlineLarge else MaterialTheme.typography.displayLarge
    val titleSize = if (isMobile) MaterialTheme.typography.headlineMedium else MaterialTheme.typography.displayMedium

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Hello, I'm",
                style = MaterialTheme.typography.headlineMedium,
                color = TextSecondary
            )

            Text(
                text = data.name,
                style = nameSize,
                color = TextPrimary,
                textAlign = TextAlign.Center
            )

            Text(
                text = data.title,
                style = titleSize,
                color = Blue,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = data.tagline,
                style = MaterialTheme.typography.bodyLarge,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(if (isMobile) 1f else 0.6f)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "📍 ${data.location}",
                style = MaterialTheme.typography.bodyMedium,
                color = TextMuted
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Blue)
                        .clickable { onNavigateTo(3) } // Projects
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = "View Projects",
                        style = MaterialTheme.typography.labelLarge,
                        color = DarkBackground
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(DarkSurfaceVariant)
                        .clickable { onNavigateTo(4) } // Contact
                        .padding(horizontal = 24.dp, vertical = 12.dp)
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
