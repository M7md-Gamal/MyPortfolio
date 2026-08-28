package com.elkabsh.myportfolio.ui.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.PortfolioData
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun AboutSection(
    data: PortfolioData,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val horizontalPadding = if (isMobile) 24.dp else 64.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .padding(horizontal = horizontalPadding, vertical = 64.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SectionTitle("About Me")

        if (isMobile) {
            // Mobile: stack vertically
            ProfileCard(data)
            EducationCard(data)
        } else {
            // Desktop: side by side
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                ProfileCard(data, Modifier.weight(1f))
                EducationCard(data, Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun ProfileCard(data: PortfolioData, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(DarkSurface)
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Profile",
            style = MaterialTheme.typography.titleLarge,
            color = Blue
        )
        Text(
            text = data.bio,
            style = MaterialTheme.typography.bodyLarge,
            color = TextSecondary
        )
    }
}

@Composable
private fun EducationCard(data: PortfolioData, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(DarkSurface)
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Education",
            style = MaterialTheme.typography.titleLarge,
            color = Green
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
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

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Languages",
            style = MaterialTheme.typography.titleLarge,
            color = Purple
        )
        data.languages.forEach { language ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
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
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .background(Blue)
                .width(60.dp)
                .height(4.dp)
        )
    }
}
