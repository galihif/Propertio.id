package com.cinurawa.propertioid.ui.pages.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.organisms.ProjectItem
import com.cinurawa.propertioid.ui.organisms.PropertySearchBox
import com.cinurawa.propertioid.ui.utils.DataProvider

@ExperimentalMaterialApi
@Composable
fun ProjectScreen(
    onProjectClicked: (Int) -> Unit
) {
    var selectedOption by remember { mutableStateOf("") }
    val listOptions = DataProvider.typeList()
    var keyword by remember { mutableStateOf("") }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                PropertySearchBox(
                    modifier = Modifier.padding(24.dp),
                    options = listOptions,
                    onOptionSelected = { selectedOption = it },
                    selectedOption = selectedOption,
                    keyword = keyword,
                    onKeywordChanged = { keyword = it }
                )
            }
        }
        item {
            TitleSectionText(
                title = "List Iklan Project",
                modifier = Modifier.fillMaxWidth()
            )
        }
        items(5) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                ProjectItem(
                    onDetailClicked = {  onProjectClicked(it) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}