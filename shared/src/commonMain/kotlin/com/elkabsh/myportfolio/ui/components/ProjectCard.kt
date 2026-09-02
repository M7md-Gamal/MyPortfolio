package com.elkabsh.myportfolio.ui.components

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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.Project
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(DarkSurface)
            .padding(24.dp)
            .then(
                if (project.githubUrl != null) Modifier.clickable {
                    uriHandler.openUri(project.githubUrl)
                } else Modifier
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header with badges
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                if (project.isFreelance) {
                    Badge("Freelance", Orange)
                }
                if (project.isGraduation) {
                    Badge("Graduation Project", Green)
                }
            }
        }

        // Project name
        Text(
            text = project.name,
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary
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

        // GitHub link
        if (project.githubUrl != null) {
            Text(
                text = "View on GitHub →",
                style = MaterialTheme.typography.labelLarge,
                color = Blue,
                modifier = Modifier.clickable {
                    // Will be handled by the browser
                }
            )
        }
    }
}

@Composable
private fun Badge(text: String, color: androidx.compose.ui.graphics.Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color.copy(alpha = 0.2f))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = color
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
