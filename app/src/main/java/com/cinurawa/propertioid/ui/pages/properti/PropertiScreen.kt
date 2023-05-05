package com.cinurawa.propertioid.ui.pages.properti

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.ErrorColumn
import com.cinurawa.propertioid.ui.organisms.LoadingItem
import com.cinurawa.propertioid.ui.organisms.PropertyItem
import com.cinurawa.propertioid.ui.organisms.PropertySearchBox
import com.cinurawa.propertioid.ui.theme.Green500

@ExperimentalMaterialApi
@Composable
fun PropertiScreen(
    keyword: String,
    selectedProType:String,
    listingType:String,
    onPropertiClicked: (Property) -> Unit,
    viewModel: PropertiViewModel = hiltViewModel()
) {
    viewModel.setQuery(keyword, selectedProType, listingType)
    val context = LocalContext.current

    LaunchedEffect(Unit){
        Log.d("GALIH", "PropertiScreen: $keyword $selectedProType $listingType")
    }

    val listProperty by remember {
        viewModel.listProperty
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
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    backgroundColor = Green500
                ) {
                    PropertySearchBox(
                        modifier = Modifier.padding(24.dp),
                        proTypeOptions = viewModel.listPropertyType,
                        onProTypeSelected = { viewModel.propertyType.value = it },
                        selectedProType = viewModel.propertyType.value,
                        listingTypeOptions = viewModel.listListingType,
                        onListingTypeSelected = { viewModel.listingType.value = it },
                        selectedListingType = viewModel.listingType.value,
                        keyword = viewModel.keyword.value,
                        onKeywordChanged = { viewModel.keyword.value = it }
                    )
                }
            }
            item {
                TitleSectionText(
                    title = if (viewModel.isSearch.value) "Hasil Pencarian" else "Properti Unggulan",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                if (isLoading) {
                    LoadingItem(
                        Modifier.padding(24.dp)
                    )
                    LoadingItem(
                        Modifier.padding(24.dp)
                    )
                }
            }
            items(listProperty) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    PropertyItem(
                        onDetailClicked = { onPropertiClicked(it) },
                        data = it
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}