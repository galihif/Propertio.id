package com.cinurawa.propertioid.ui.molecules

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun IconTextBadge(
    @DrawableRes icon: Int,
    text: String,
    color: Color = Color.Gray,
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 0.dp,
        backgroundColor = color.copy(alpha = 0.1f)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(24.dp)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = "",
            )
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                color = color,
                fontSize = 12.sp
            )
        }
    }
}


@Composable
fun IconTextBadge(
    icon: ImageVector,
    text: String,
    color: Color = Color.Gray,
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 0.dp,
        backgroundColor = color.copy(alpha = 0.1f)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(24.dp)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Icon(
                imageVector = icon, contentDescription = "",
                tint = color
            )
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                color = color,
                fontSize = 12.sp
            )
        }
    }
}