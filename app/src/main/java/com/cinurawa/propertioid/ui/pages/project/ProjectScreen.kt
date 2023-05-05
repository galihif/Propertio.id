package com.cinurawa.propertioid.ui.pages.project

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.ErrorColumn
import com.cinurawa.propertioid.ui.organisms.LoadingItem
import com.cinurawa.propertioid.ui.organisms.ProjectItem
import com.cinurawa.propertioid.ui.organisms.ProjectSearchBox

@ExperimentalMaterialApi
@Composable
fun ProjectScreen(
    keyword:String,
    selectedProType:String,
    onProjectClicked: (Project) -> Unit,
    viewModel: ProjectViewModel = hiltViewModel()
) {
    viewModel.setQuery(keyword,selectedProType)
    val context = LocalContext.current

    val listProject by remember{
        viewModel.listProject
    }.collectAsState()
    val isLoading by remember{
        viewModel.isProjectLoading
    }.collectAsState()

    val error by remember{
        viewModel.error
    }.collectAsState()

    LaunchedEffect(error) {
        if (error.isNotEmpty()) {
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
    }
    if (error.isNotEmpty()){
        ErrorColumn(error = error)
    }else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    ProjectSearchBox(
                        modifier = Modifier.padding(24.dp),
                        proTypeOptions = viewModel.listPropertyType,
                        onProTypeSelected = { viewModel.selectedProType.value = it },
                        selectedProType = viewModel.selectedProType.value,
                        keyword = viewModel.keyword.value,
                        onKeywordChanged = { viewModel.keyword.value = it },
                        onSearchClick = { viewModel.searchProject() }
                    )
                }
            }
            item {
                TitleSectionText(
                    title = "List Iklan Project",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item{
                if(isLoading){
                    LoadingItem(
                        Modifier.padding(24.dp)
                    )
                    LoadingItem(
                        Modifier.padding(24.dp)
                    )
                }
            }
            items(listProject) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ){
                    ProjectItem(
                        onDetailClicked = { onProjectClicked(it) },
                        data = it
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}