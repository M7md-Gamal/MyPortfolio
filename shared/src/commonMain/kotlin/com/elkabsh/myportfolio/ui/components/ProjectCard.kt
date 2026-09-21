package com.elkabsh.myportfolio.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.Project
import com.elkabsh.myportfolio.ui.theme.AccentAmber
import com.elkabsh.myportfolio.ui.theme.AccentEmerald
import com.elkabsh.myportfolio.ui.theme.BorderColor
import com.elkabsh.myportfolio.ui.theme.DarkSurface
import com.elkabsh.myportfolio.ui.theme.DarkSurfaceVariant
import com.elkabsh.myportfolio.ui.theme.GoldPrimary
import com.elkabsh.myportfolio.ui.theme.TextMuted
import com.elkabsh.myportfolio.ui.theme.TextPrimary
import com.elkabsh.myportfolio.ui.theme.TextSecondary

@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val githubUrl = project.githubUrl
    var showArchitecture by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(DarkSurface)
            .border(1.dp, BorderColor.copy(alpha = 0.6f), RoundedCornerShape(14.dp))
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Header with domain badge and category tags
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                if (project.isFreelance) {
                    Badge("Freelance", AccentAmber)
                }
                if (project.isGraduation) {
                    Badge("Graduation Project", AccentEmerald)
                }
            }

            if (project.metric != null) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(GoldPrimary.copy(alpha = 0.12f))
                        .border(1.dp, GoldPrimary.copy(alpha = 0.25f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = project.metric,
                        style = MaterialTheme.typography.bodySmall,
                        color = GoldPrimary,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // Project name
        Text(
            text = project.name,
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary,
            fontWeight = FontWeight.Bold
        )

        // Description
        Text(
            text = project.description,
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary,
            textAlign = TextAlign.Start
        )

        // Tech stack chips
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            project.techStack.forEach { tech ->
                TechChip(tech)
            }
        }

        // Expandable Architecture Highlights
        if (project.architectureHighlights.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(DarkSurfaceVariant.copy(alpha = 0.4f))
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(6.dp))
                        .clickable(
                            role = Role.Button,
                            onClickLabel = if (showArchitecture) "Hide architecture details" else "Show architecture details"
                        ) { showArchitecture = !showArchitecture }
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Engineering & Architecture Highlights",
                        style = MaterialTheme.typography.labelMedium,
                        color = GoldPrimary,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = if (showArchitecture) "▲ Collapse" else "▼ Expand",
                        style = MaterialTheme.typography.labelSmall,
                        color = TextMuted
                    )
                }

                AnimatedVisibility(
                    visible = showArchitecture,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    Column(
                        modifier = Modifier.padding(top = 6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        project.architectureHighlights.forEach { highlight ->
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Text(
                                    text = "▹",
                                    color = GoldPrimary,
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = highlight,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = TextSecondary
                                )
                            }
                        }
                    }
                }
            }
        }

        // GitHub link action
        if (githubUrl != null) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(
                        role = Role.Button,
                        onClickLabel = "Open ${project.name} on GitHub"
                    ) {
                        uriHandler.openUri(githubUrl)
                    }
                    .semantics {
                        role = Role.Button
                        onClick(label = "Open ${project.name} on GitHub") {
                            uriHandler.openUri(githubUrl)
                            true
                        }
                    }
                    .padding(vertical = 6.dp, horizontal = 2.dp)
            ) {
                Text(
                    text = "View on GitHub ↗",
                    style = MaterialTheme.typography.labelLarge,
                    color = GoldPrimary,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun Badge(text: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color.copy(alpha = 0.18f))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = color,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun TechChip(tech: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(DarkSurfaceVariant)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = tech,
            style = MaterialTheme.typography.bodySmall,
            color = TextSecondary
        )
    }
}
