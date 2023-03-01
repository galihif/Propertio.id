package com.cinurawa.propertioid.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.component.HomeBanner
import com.cinurawa.propertioid.ui.component.HomeTab

@Composable
fun HomeScreen() {
    var selectedMenu by remember { mutableStateOf(HomeTab.Beli) }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            HomeBanner()
        }
        item {
            HomeTab(selectedMenu) {
                selectedMenu = it
            }
        }
    }
}