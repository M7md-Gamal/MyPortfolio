package com.elkabsh.myportfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.ui.theme.DarkBackground
import com.elkabsh.myportfolio.ui.theme.DarkSurface
import com.elkabsh.myportfolio.ui.theme.GoldPrimary
import com.elkabsh.myportfolio.ui.theme.TextPrimary

@Composable
fun TopBar(
    sections: List<String>,
    currentSection: Int,
    onSectionClick: (Int) -> Unit,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    var menuExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkBackground.copy(alpha = 0.95f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = if (isMobile) 24.dp else 80.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Portfolio",
                style = MaterialTheme.typography.titleLarge,
                color = GoldPrimary,
                fontWeight = FontWeight.Bold
            )

            if (!isMobile) {
                // Desktop: inline nav links
                Row(
                    horizontalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    sections.forEachIndexed { index, section ->
                        Text(
                            text = section,
                            style = MaterialTheme.typography.labelLarge,
                            color = if (index == currentSection) GoldPrimary else TextPrimary,
                            modifier = Modifier.clickable(
                                role = Role.Button,
                                onClickLabel = "Navigate to $section"
                            ) {
                                onSectionClick(index)
                                menuExpanded = false
                            }
                        )
                    }
                }
            } else {
                // Mobile: accessible hamburger button
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable(
                            role = Role.Button,
                            onClickLabel = if (menuExpanded) "Close navigation menu" else "Open navigation menu"
                        ) { menuExpanded = !menuExpanded }
                        .semantics {
                            role = Role.Button
                            contentDescription = if (menuExpanded) "Close navigation menu" else "Open navigation menu"
                        }
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(24.dp)
                            .height(2.dp)
                            .background(if (menuExpanded) GoldPrimary else TextPrimary)
                    )
                    Box(
                        modifier = Modifier
                            .width(24.dp)
                            .height(2.dp)
                            .background(if (menuExpanded) GoldPrimary else TextPrimary)
                    )
                    Box(
                        modifier = Modifier
                            .width(24.dp)
                            .height(2.dp)
                            .background(if (menuExpanded) GoldPrimary else TextPrimary)
                    )
                }
            }
        }

        // Mobile dropdown menu rendered in flow without brittle offsets
        if (isMobile && menuExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkSurface)
                    .padding(horizontal = 24.dp, vertical = 12.dp)
            ) {
                sections.forEachIndexed { index, section ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .clickable(
                                role = Role.Button,
                                onClickLabel = "Navigate to $section"
                            ) {
                                onSectionClick(index)
                                menuExpanded = false
                            }
                            .padding(horizontal = 16.dp, vertical = 14.dp)
                    ) {
                        Text(
                            text = section,
                            style = MaterialTheme.typography.bodyLarge,
                            color = if (index == currentSection) GoldPrimary else TextPrimary
                        )
                    }
                }
            }
        }
    }
}
