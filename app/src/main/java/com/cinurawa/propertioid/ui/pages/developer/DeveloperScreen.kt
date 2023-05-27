package com.cinurawa.propertioid.ui.pages.developer

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.ErrorColumn
import com.cinurawa.propertioid.ui.organisms.DeveloperItem
import com.cinurawa.propertioid.ui.organisms.LoadingItem

@Composable
fun DeveloperScreen(
    viewModel: DeveloperViewModel = hiltViewModel(),
    onDetailClicked: (id: Int) -> Unit
) {
    val context = LocalContext.current

    val listDeveloper by remember {
        viewModel.listDeveloper
    }.collectAsState()
    val isLoading by remember {
        viewModel.isLoading
    }.collectAsState()
    val error by remember {
        viewModel.error
    }.collectAsState()

    LaunchedEffect(error) {
        if (error.isNotEmpty()) {
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
    }

    if (error.isNotEmpty()) {
        ErrorColumn(error = error)
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.testTag("developer_screen")
        ) {
            item {
                TitleSectionText(
                    title = "List Developer",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
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
            items(listDeveloper) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    DeveloperItem(
                        onDetailClicked = {
                            onDetailClicked(it.id)
                        },
                        data = it
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

    }
}