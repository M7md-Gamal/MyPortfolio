package com.elkabsh.myportfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun FooterSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkSurface)
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "© 2026 Mohamed Gamal Abdelwahab. Built with Compose Multiplatform.",
            style = MaterialTheme.typography.bodySmall,
            color = TextMuted
        )
    }
}
