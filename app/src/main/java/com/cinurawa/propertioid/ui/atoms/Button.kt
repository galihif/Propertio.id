package com.cinurawa.propertioid.ui.atoms

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
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

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    title: String,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = "",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            if (trailingIcon != null) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = "",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun MyIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconTint: Color = Color.Gray,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.border(1.dp, iconTint.copy(alpha = 0.5f), RoundedCornerShape(5.dp)),
        onClick = onClick,
    ) {
        Icon(
            imageVector = icon,
            tint = iconTint,
            contentDescription = ""
        )
    }

}