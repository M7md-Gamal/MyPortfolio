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
import com.elkabsh.myportfolio.model.SkillColor
import com.elkabsh.myportfolio.ui.components.SkillChip
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun SkillsSection(
    data: PortfolioData,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val horizontalPadding = if (isMobile) 24.dp else 80.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkSurface)
            .padding(horizontal = horizontalPadding, vertical = 80.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        SectionTitle("Skills")

        if (isMobile) {
            // Mobile: single column with all categories
            data.skillCategories.forEach { category ->
                SkillCategoryCard(category, isMobile)
            }
        } else {
            // Desktop: two-column grid
            data.skillCategories.chunked(2).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    row.forEach { category ->
                        SkillCategoryCard(category, isMobile, Modifier.weight(1f))
                    }
                    if (row.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
private fun SkillCategoryCard(
    category: com.elkabsh.myportfolio.model.SkillCategory,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val accentColor = when (category.color) {
        SkillColor.BLUE -> Blue
        SkillColor.GREEN -> Green
        SkillColor.ORANGE -> Orange
        SkillColor.PURPLE -> Purple
        SkillColor.YELLOW -> Yellow
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(DarkSurfaceVariant)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Category header
        Text(
            text = category.name,
            style = MaterialTheme.typography.titleLarge,
            color = accentColor
        )

        // Skills grid
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            category.skills.forEach { skill ->
                SkillChip(
                    name = skill.name,
                    color = category.color
                )
            }
        }
    }
}
