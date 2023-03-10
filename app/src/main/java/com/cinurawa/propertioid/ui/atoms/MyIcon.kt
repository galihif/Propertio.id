package com.cinurawa.propertioid.ui.atoms

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MyIcon(
    icon:ImageVector,
    contentDescription:String = ""
) {
    Icon(imageVector = icon, contentDescription = contentDescription)
}