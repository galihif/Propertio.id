package com.cinurawa.propertioid.ui.pages.agent

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.organisms.AgentItem

@Composable
fun AgentScreen() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        item {
            TitleSectionText(
                title = "List Agent",
                modifier = Modifier.fillMaxWidth()
            )
        }
        items(5) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                AgentItem(
                    onDetailClicked = {

                    }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}