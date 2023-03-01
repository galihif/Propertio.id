package com.cinurawa.propertioid.ui.screen.home

import SelectDropdown
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.component.HomeBanner
import com.cinurawa.propertioid.ui.component.HomeTab

@ExperimentalMaterialApi
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
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HomeBanner()
                HomeTab(selectedMenu) {
                    selectedMenu = it
                }
                HomeSearchCard()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun HomeSearchCard() {
    val context = LocalContext.current
    val options = listOf("Option 1", "Option 2", "Option 3")
    var selectedOption by remember { mutableStateOf("") }

    LaunchedEffect(key1 = selectedOption){
        Toast.makeText(context, selectedOption, Toast.LENGTH_SHORT).show()
    }
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SelectDropdown(
                options = options,
                selectedOption = selectedOption,
                onOptionSelected = { newOption ->
                    selectedOption = newOption
                }
            )
        }
    }
}
