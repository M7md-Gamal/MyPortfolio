package com.elkabsh.myportfolio.ui.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.PortfolioData
import com.elkabsh.myportfolio.ui.PortfolioViewModel
import com.elkabsh.myportfolio.ui.theme.DarkSurface
import com.elkabsh.myportfolio.ui.theme.DarkSurfaceVariant
import com.elkabsh.myportfolio.ui.theme.GoldPrimary
import com.elkabsh.myportfolio.ui.theme.TextPrimary
import com.elkabsh.myportfolio.ui.theme.TextSecondary
import myportfolio.shared.generated.resources.Res
import myportfolio.shared.generated.resources.github
import myportfolio.shared.generated.resources.linkedin
import myportfolio.shared.generated.resources.whatsapp
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ContactSection(
    data: PortfolioData,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val horizontalPadding = if (isMobile) 24.dp else 80.dp
    val uriHandler = LocalUriHandler.current
    val whatsAppUrl = PortfolioViewModel.formatWhatsAppUrl(data.phone)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkSurface)
            .padding(horizontal = horizontalPadding, vertical = 80.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        SectionTitle("Get In Touch")

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                text = "I'm always open to discussing new projects, creative ideas, or opportunities to be part of your vision.",
                style = MaterialTheme.typography.bodyLarge,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(if (isMobile) 1f else 0.6f)
            )

            // Contact cards
            if (isMobile) {
                // Mobile: single column with stacked cards
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ContactCard(
                        title = "Email",
                        value = data.email,
                        icon = Icons.Outlined.Mail,
                        onClick = { uriHandler.openUri("mailto:${data.email}") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    ContactCard(
                        title = "WhatsApp",
                        value = data.phone,
                        icon = vectorResource(Res.drawable.whatsapp),
                        onClick = { uriHandler.openUri(whatsAppUrl) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ContactCard(
                            title = "LinkedIn",
                            value = "Connect",
                            onClick = { uriHandler.openUri(data.linkedInUrl) },
                            icon = vectorResource(Res.drawable.linkedin),
                            modifier = Modifier.weight(1f)
                        )
                        ContactCard(
                            title = "GitHub",
                            value = "Profile",
                            onClick = { uriHandler.openUri(data.githubUrl) },
                            icon = vectorResource(Res.drawable.github),
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
                        icon = Icons.Outlined.Mail,
                        onClick = { uriHandler.openUri("mailto:${data.email}") },
                        modifier = Modifier.weight(1f)
                    )
                    ContactCard(
                        title = "WhatsApp",
                        value = data.phone,
                        icon = vectorResource(Res.drawable.whatsapp),
                        onClick = { uriHandler.openUri(whatsAppUrl) },
                        modifier = Modifier.weight(1f)
                    )
                    ContactCard(
                        title = "LinkedIn",
                        value = "Connect on LinkedIn",
                        icon = vectorResource(Res.drawable.linkedin),
                        onClick = { uriHandler.openUri(data.linkedInUrl) },
                        modifier = Modifier.weight(1f)
                    )
                    ContactCard(
                        title = "GitHub",
                        value = "View GitHub Profile",
                        icon = vectorResource(Res.drawable.github),
                        onClick = { uriHandler.openUri(data.githubUrl) },
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
    icon: ImageVector,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(DarkSurfaceVariant)
            .clickable(
                role = Role.Button,
                onClickLabel = "Contact via $title"
            ) { onClick() }
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = TextPrimary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = GoldPrimary
        )
    }
}
