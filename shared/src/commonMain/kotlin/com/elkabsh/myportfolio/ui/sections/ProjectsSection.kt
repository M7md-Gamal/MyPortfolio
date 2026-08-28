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
import com.elkabsh.myportfolio.ui.components.ProjectCard
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun ProjectsSection(
    data: PortfolioData,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val horizontalPadding = if (isMobile) 24.dp else 64.dp
    val columnsPerRow = if (isMobile) 1 else 2

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .padding(horizontal = horizontalPadding, vertical = 64.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SectionTitle("Projects")

        data.projects.chunked(columnsPerRow).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(if (isMobile) 0.dp else 32.dp)
            ) {
                row.forEach { project ->
                    ProjectCard(
                        project = project,
                        modifier = if (!isMobile) Modifier.weight(1f) else Modifier.fillMaxWidth()
                    )
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
