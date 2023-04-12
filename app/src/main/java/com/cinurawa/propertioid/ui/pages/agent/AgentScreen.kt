package com.cinurawa.propertioid.ui.pages.agent

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.organisms.AgentItem
import com.cinurawa.propertioid.ui.organisms.LoadingItem

@Composable
fun AgentScreen(
    viewModel: AgentViewModel = hiltViewModel(),
    onAgentClicked: (Int) -> Unit = {},
) {
    val context = LocalContext.current

    val listAgent by remember {
        viewModel.listAgent
    }.collectAsState()
    val isLoading by remember {
        viewModel.isLoading
    }.collectAsState()
    val error by remember {
        viewModel.error
    }.collectAsState()

    LaunchedEffect(error){
        if (error.isNotEmpty()) {
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        item {
            TitleSectionText(
                title = "List Agent",
                modifier = Modifier.fillMaxWidth()
            )
        }
        item{
            if (isLoading) {
                LoadingItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                )
                LoadingItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                )
            }
        }
        items(listAgent) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                AgentItem(
                    onDetailClicked = {
                        onAgentClicked(it.id)
                    },
                    data = it
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}