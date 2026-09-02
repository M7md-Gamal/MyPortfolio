package com.elkabsh.myportfolio.ui.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.PortfolioData
import com.elkabsh.myportfolio.ui.components.ProjectCard
import com.elkabsh.myportfolio.ui.theme.DarkBackground

@Composable
fun ProjectsSection(
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
        SectionTitle("Projects")

        if (isMobile) {
            // Mobile: single column
            data.projects.forEach { project ->
                ProjectCard(project)
            }
        } else {
            // Desktop: two-column grid
            data.projects.chunked(2).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    row.forEach { project ->
                        ProjectCard(project, Modifier.weight(1f))
                    }
                    if (row.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
