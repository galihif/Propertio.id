package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconText(
    modifier: Modifier= Modifier,
    leadingIcon:ImageVector?=null,
    text:String,
    trailingIcon:ImageVector?=null,
    iconTint:Color = Color.Gray,
    spacing:Int = 5
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(spacing.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        if (leadingIcon!=null){
            Icon(imageVector = leadingIcon, contentDescription = "", tint = iconTint)
        }
        Text(text = text, style = MaterialTheme.typography.body2, color = Color.Gray)
        if (trailingIcon!=null){
            Icon(imageVector = trailingIcon, contentDescription = "", tint = iconTint)
        }
    }
}