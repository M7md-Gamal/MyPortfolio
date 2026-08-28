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
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.PortfolioData
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun ContactSection(
    data: PortfolioData,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val horizontalPadding = if (isMobile) 24.dp else 64.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkSurface)
            .padding(horizontal = horizontalPadding, vertical = 64.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SectionTitle("Get In Touch")

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "I'm always open to discussing new projects, creative ideas, or opportunities to be part of your vision.",
                style = MaterialTheme.typography.bodyLarge,
                color = TextSecondary,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                modifier = Modifier.fillMaxWidth(if (isMobile) 1f else 0.6f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Contact cards
            if (isMobile) {
                // Mobile: 2x2 grid
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ContactCard(
                            title = "Email",
                            value = data.email,
                            icon = "📧",
                            modifier = Modifier.weight(1f)
                        )
                        ContactCard(
                            title = "Phone",
                            value = data.phone,
                            icon = "📱",
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ContactCard(
                            title = "LinkedIn",
                            value = "Connect",
                            icon = "💼",
                            modifier = Modifier.weight(1f)
                        )
                        ContactCard(
                            title = "GitHub",
                            value = "Profile",
                            icon = "🐙",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            } else {
                // Desktop: single row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    ContactCard(
                        title = "Email",
                        value = data.email,
                        icon = "📧",
                        modifier = Modifier.weight(1f)
                    )
                    ContactCard(
                        title = "Phone",
                        value = data.phone,
                        icon = "📱",
                        modifier = Modifier.weight(1f)
                    )
                    ContactCard(
                        title = "LinkedIn",
                        value = "Connect on LinkedIn",
                        icon = "💼",
                        modifier = Modifier.weight(1f)
                    )
                    ContactCard(
                        title = "GitHub",
                        value = "View GitHub Profile",
                        icon = "🐙",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun ContactCard(
    title: String,
    value: String,
    icon: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(DarkSurfaceVariant)
            .clickable { /* Handle click based on type */ }
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = icon,
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = TextPrimary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Blue
        )
    }
}
