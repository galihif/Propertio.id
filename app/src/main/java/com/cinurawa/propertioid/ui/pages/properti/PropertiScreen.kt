package com.cinurawa.propertioid.ui.pages.properti

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.organisms.PropertyItem
import com.cinurawa.propertioid.ui.organisms.PropertySearchBox
import com.cinurawa.propertioid.ui.theme.Green500
import com.cinurawa.propertioid.ui.utils.DataProvider

@ExperimentalMaterialApi
@Composable
fun PropertiScreen(
    onPropertiClicked: (Property) -> Unit,
    viewModel: PropertiViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    var selectedOption by remember { mutableStateOf("") }
    val listOptions = DataProvider.typeList()
    var keyword by remember { mutableStateOf("") }

    val listProperty by remember{
        viewModel.listProperty
    }.collectAsState()

    val isLoading by remember{
        viewModel.isLoading
    }.collectAsState()

    val error by remember{
        viewModel.error
    }.collectAsState()

    LaunchedEffect(error) {
        if (error.isNotEmpty()) {
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
    }

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
        item{
            if(isLoading){
                CircularProgressIndicator()
            }
        }
        items(listProperty) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ){
                PropertyItem(
                    onDetailClicked = { onPropertiClicked(it) },
                    data = it
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}