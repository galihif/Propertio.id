package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun IconTextCardColumn(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    text: String,
    subText: String? = null,
    trailingIcon: ImageVector? = null,
    color: Color = Color.Gray,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        elevation = 0.dp,
        backgroundColor = color.copy(alpha = 0.1f)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(98.dp)
                .padding(10.dp)
        ) {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon, contentDescription = "",
                    tint = color
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                color = color,
                fontSize = 12.sp
            )
            if (subText != null) {
                Text(
                    text = subText,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary,
                    fontSize = 12.sp
                )
            }
            if (trailingIcon != null) {
                Icon(
                    imageVector = trailingIcon, contentDescription = "",
                    tint = color
                )
            }
        }
    }
}