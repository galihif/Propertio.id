package com.cinurawa.propertioid.ui.screen.home

import androidx.compose.foundation.layout.*
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
            Column {
                HomeBanner()
                Spacer(modifier = Modifier.height(16.dp))
                HomeTab(selectedMenu) {
                    selectedMenu = it
                }
            }
        }
    }
}