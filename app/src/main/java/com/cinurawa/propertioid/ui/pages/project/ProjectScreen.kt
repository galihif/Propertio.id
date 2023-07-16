package com.cinurawa.propertioid.ui.pages.project

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
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
    keyword: String,
    selectedProType: String,
    onProjectClicked: (Project) -> Unit,
    viewModel: ProjectViewModel = hiltViewModel()
) {
    viewModel.setQuery(keyword, selectedProType)
    val context = LocalContext.current

    val listProject by remember {
        viewModel.listProject
    }.collectAsState()
    val isLoading by remember {
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.testTag("project_screen")
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
                    title = if (viewModel.isSearch.value) "Hasil Pencarian" else "Project",
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
            items(listProject) {project ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    ProjectItem(
                        onDetailClicked = { onProjectClicked(project) },
                        data = project
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
            item{
                if (listProject.isEmpty()){
                    Text(
                        text = "Tidak ada proyek yang ditemukan",
                        modifier = Modifier.padding(24.dp).fillMaxWidth().testTag("empty_state"),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}