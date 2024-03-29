package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object HomeTab {
    const val Beli = "Beli"
    const val Sewa = "Sewa"
    const val Project = "Project"
}

@Composable
fun HomeTab(
    modifier: Modifier = Modifier,
    selectedMenu: String = HomeTab.Beli,
    onMenuSelected: (String) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ItemHomeTab(
            Modifier
                .weight(1f)
                .clickable { onMenuSelected(HomeTab.Beli) },
            title = HomeTab.Beli,
            selected = selectedMenu == HomeTab.Beli
        )
        ItemHomeTab(
            Modifier
                .weight(1f)
                .clickable { onMenuSelected(HomeTab.Sewa) },
            title = HomeTab.Sewa,
            selected = selectedMenu == HomeTab.Sewa
        )
        ItemHomeTab(
            Modifier
                .weight(1f)
                .clickable { onMenuSelected(HomeTab.Project) },
            title = HomeTab.Project,
            selected = selectedMenu == HomeTab.Project
        )
    }
}

@Composable
fun ItemHomeTab(
    modifier: Modifier = Modifier,
    title: String,
    selected: Boolean,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        elevation = 8.dp,
        backgroundColor = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
    ) {
        Text(
            title,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(16.dp),
            color = if (selected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSurface
        )
    }
}