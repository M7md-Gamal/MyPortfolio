package com.elkabsh.myportfolio.ui.sections

import androidx.compose.foundation.background
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
fun AboutSection(
    data: PortfolioData,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val horizontalPadding = if (isMobile) 24.dp else 80.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .padding(horizontal = horizontalPadding, vertical = 80.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        SectionTitle("About Me")

        if (isMobile) {
            // Mobile: storytelling flow
            ProfileStory(data)
            EducationStory(data)
        } else {
            // Desktop: split layout with visual hierarchy
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(64.dp),
                verticalAlignment = Alignment.Top
            ) {
                // Left: Profile story
                ProfileStory(data, Modifier.weight(1f))

                // Right: Education & Languages
                EducationStory(data, Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun ProfileStory(data: PortfolioData, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Profile intro
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = data.bio,
                style = MaterialTheme.typography.bodyLarge,
                color = TextSecondary
            )
        }

        // Key stats row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            StatItem("6+", "Projects")
            StatItem("7+", "Skills")
            StatItem("3+", "Domains")
        }
    }
}

@Composable
private fun StatItem(value: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.displayMedium,
            color = Blue,
            textAlign = TextAlign.Center
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = TextMuted,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun EducationStory(data: PortfolioData, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(DarkSurface)
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Education header
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "Education",
                style = MaterialTheme.typography.titleLarge,
                color = Green
            )
            Text(
                text = data.education.degree,
                style = MaterialTheme.typography.headlineMedium,
                color = TextPrimary
            )
            Text(
                text = data.education.university,
                style = MaterialTheme.typography.bodyLarge,
                color = TextSecondary
            )
            Text(
                text = data.education.dateRange,
                style = MaterialTheme.typography.bodyMedium,
                color = TextMuted
            )
            Text(
                text = "Grade: ${data.education.grade}",
                style = MaterialTheme.typography.bodyMedium,
                color = Yellow
            )
        }

        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(BorderColor)
        )

        // Languages
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "Languages",
                style = MaterialTheme.typography.titleLarge,
                color = Purple
            )
            data.languages.forEach { language ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = language.name,
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextPrimary
                    )
                    Text(
                        text = language.proficiency,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextMuted
                    )
                }
            }
        }
    }
}

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .background(Blue)
                .width(60.dp)
                .height(4.dp)
        )
    }
}
