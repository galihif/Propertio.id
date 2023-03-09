package com.cinurawa.propertioid.ui.pages.properti

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.organisms.PropertyItem
import com.cinurawa.propertioid.ui.organisms.PropertySearchBox
import com.cinurawa.propertioid.ui.theme.Green500
import com.cinurawa.propertioid.ui.utils.DataProvider

@ExperimentalMaterialApi
@Composable
fun PropertiScreen() {
    var selectedOption by remember { mutableStateOf("") }
    val listOptions = DataProvider.typeList()
    var keyword by remember { mutableStateOf("") }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                backgroundColor = Green500
            ){
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
                title = "List Iklan Properti",
                modifier = Modifier.fillMaxWidth()
            )
        }
        items(5) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ){
                PropertyItem()
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}