package com.elkabsh.myportfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.SkillColor
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun SkillChip(
    name: String,
    color: SkillColor,
    modifier: Modifier = Modifier
) {
    val (backgroundColor, textColor) = when (color) {
        SkillColor.BLUE -> Blue.copy(alpha = 0.15f) to Blue
        SkillColor.GREEN -> Green.copy(alpha = 0.15f) to Green
        SkillColor.ORANGE -> Orange.copy(alpha = 0.15f) to Orange
        SkillColor.PURPLE -> Purple.copy(alpha = 0.15f) to Purple
        SkillColor.YELLOW -> Yellow.copy(alpha = 0.15f) to Yellow
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            color = textColor
        )
    }
}
