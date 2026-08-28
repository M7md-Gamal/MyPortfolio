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
    val horizontalPadding = if (isMobile) 24.dp else 64.dp
    val columnsPerRow = if (isMobile) 1 else 2

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkSurface)
            .padding(horizontal = horizontalPadding, vertical = 64.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SectionTitle("Skills")

        data.skillCategories.chunked(columnsPerRow).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(if (isMobile) 0.dp else 32.dp)
            ) {
                row.forEach { category ->
                    Column(
                        modifier = Modifier
                            .then(
                                if (!isMobile) Modifier.weight(1f) else Modifier.fillMaxWidth()
                            )
                            .clip(RoundedCornerShape(12.dp))
                            .background(DarkSurfaceVariant)
                            .padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = when (category.color) {
                                SkillColor.BLUE -> Blue
                                SkillColor.GREEN -> Green
                                SkillColor.ORANGE -> Orange
                                SkillColor.PURPLE -> Purple
                                SkillColor.YELLOW -> Yellow
                            }
                        )
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
                if (!isMobile && row.size < columnsPerRow) {
                    repeat(columnsPerRow - row.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
