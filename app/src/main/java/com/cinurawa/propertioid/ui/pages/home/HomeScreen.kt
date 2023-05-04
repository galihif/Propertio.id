package com.cinurawa.propertioid.ui.pages.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.atoms.LihatSemuaButton
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.ErrorColumn
import com.cinurawa.propertioid.ui.molecules.HomeBanner
import com.cinurawa.propertioid.ui.organisms.*
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    onPropertyClicked: (Property) -> Unit = {},
    onProjectClicked: (Project) -> Unit = {},
    onLihatSemuaPropertyClicked: () -> Unit = {},
    onLihatSemuaProjectClicked: () -> Unit = {},
    onSearch: (
        keyword: String,
        selectedProType: String,
        listingType: String,
    ) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val listProperty by remember {
        viewModel.listProperty
    }.collectAsState()

    val listProject by remember {
        viewModel.listProject
    }.collectAsState()

    val isPropertyLoading by remember {
        viewModel.isPropertyLoading
    }.collectAsState()

    val isProjectLoading by remember {
        viewModel.isProjectLoading
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
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription = "home_screen"
                },
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.Top
        ) {
            item {
                HomeBanner(
                    modifier = Modifier.semantics {
                        contentDescription = "home_banner"
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                HomeTab(
                    modifier = Modifier.semantics {
                        contentDescription = "home_tab"
                    },
                    selectedMenu = viewModel.selectedMenu.value,
                    onMenuSelected = { viewModel.selectedMenu.value = it }
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                PropertySearchBox(
                    Modifier.semantics {
                        contentDescription = "home_search"
                    },
                    options = viewModel.listPropertyType,
                    onOptionSelected = { viewModel.selectedPropertyType.value = it },
                    selectedOption = viewModel.selectedPropertyType.value,
                    keyword = viewModel.keyword.value,
                    onKeywordChanged = { viewModel.keyword.value = it },
                    onSearchClick = {
                        onSearch(
                            viewModel.keyword.value,
                            viewModel.selectedPropertyType.value,
                            viewModel.selectedMenu.value
                        )
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                HomeCarousel(modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "home_carousel"
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                TitleSectionText(
                    title = "Rekomendasi Properti",
                    modifier = Modifier
                        .semantics {
                            contentDescription = "rekomendasi_properti"
                        }
                        .fillMaxWidth()
                )
            }
            item {
                if (isPropertyLoading) {
                    Spacer(modifier = Modifier.height(24.dp))
                    LoadingItem()
                    LoadingItem()
                }
            }
            items(listProperty) { property ->
                Spacer(modifier = Modifier.height(24.dp))
                PropertyItem(
                    modifier = Modifier,
                    onDetailClicked = { onPropertyClicked(property) },
                    data = property
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                LihatSemuaButton(
                    Modifier.fillMaxWidth(),
                    onClick = onLihatSemuaPropertyClicked
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                TitleSectionText(
                    title = "Project Pilihan",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                if (isProjectLoading) {
                    Spacer(modifier = Modifier.height(24.dp))
                    LoadingItem()
                    LoadingItem()
                }
            }
            items(listProject) {
                Spacer(modifier = Modifier.height(24.dp))
                ProjectItem(
                    onDetailClicked = { onProjectClicked(it) },
                    data = it
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                LihatSemuaButton(
                    Modifier.fillMaxWidth(),
                    onClick = onLihatSemuaProjectClicked
                )
            }
        }
    }
}


