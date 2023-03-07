package com.cinurawa.propertioid.ui.atoms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LihatSemuaButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary.copy(0.1f),
            contentColor = MaterialTheme.colors.primary
        ),
        elevation = ButtonDefaults.elevation(0.dp),
        contentPadding = PaddingValues(vertical = 14.dp)
    ) {
        Text(text = "Lihat Semua")
    }
}