package com.elkabsh.myportfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.model.SkillColor
import com.elkabsh.myportfolio.ui.theme.AccentAmber
import com.elkabsh.myportfolio.ui.theme.AccentBlue
import com.elkabsh.myportfolio.ui.theme.AccentEmerald
import com.elkabsh.myportfolio.ui.theme.GoldPrimary
import com.elkabsh.myportfolio.ui.theme.WarmCream

@Composable
fun SkillChip(
    name: String,
    color: SkillColor,
    modifier: Modifier = Modifier
) {
    val (backgroundColor, textColor) = when (color) {
        SkillColor.BLUE -> AccentBlue.copy(alpha = 0.15f) to AccentBlue
        SkillColor.GREEN -> AccentEmerald.copy(alpha = 0.15f) to AccentEmerald
        SkillColor.ORANGE -> AccentAmber.copy(alpha = 0.15f) to AccentAmber
        SkillColor.PURPLE -> GoldPrimary.copy(alpha = 0.15f) to GoldPrimary
        SkillColor.YELLOW -> WarmCream.copy(alpha = 0.15f) to WarmCream
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
