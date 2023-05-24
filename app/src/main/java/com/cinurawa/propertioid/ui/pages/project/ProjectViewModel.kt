package com.cinurawa.propertioid.ui.pages.project

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.ui.utils.DataProvider
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel
@Inject constructor(
    private val repo: MainRepository
) : ViewModel() {
    private var _listProject = MutableStateFlow<List<Project>>(emptyList())
    val listProject = _listProject
    private var _isProjectLoading = MutableStateFlow(true)
    val isProjectLoading = _isProjectLoading

    private var _error = MutableStateFlow("")
    val error = _error

    val isSearch = mutableStateOf(false)
    val listPropertyType = DataProvider.listPropertyType
    val keyword = mutableStateOf("")
    val selectedProType = mutableStateOf("")
    fun setQuery(keyword: String, selectedProType: String) {
        if (keyword == "default" && selectedProType == "default") {
            getListProject()
            return
        }
        this.keyword.value = keyword
        this.selectedProType.value = selectedProType
        searchProject()
    }

    fun searchProject() {
        isSearch.value = true
        viewModelScope.launch {
            repo.getAllProject(keyword.value, selectedProType.value).collect {
                when (it) {
                    is Resource.Loading -> {
                        _isProjectLoading.value = true
                    }

                    is Resource.Success -> {
                        _isProjectLoading.value = false
                        _listProject.value =
                            if (it.data.isNullOrEmpty()) emptyList() else it.data.take(3)
                    }

                    is Resource.Error -> {
                        _isProjectLoading.value = false
                        _error.value = it.message ?: "Error"
                    }
                }
            }
        }
    }

    private fun getListProject() {
        isSearch.value = false
        viewModelScope.launch {
            repo.getAllProject().collect {
                when (it) {
                    is Resource.Loading -> {
                        _isProjectLoading.value = true
                    }

                    is Resource.Success -> {
                        _isProjectLoading.value = false
                        _listProject.value =
                            if (it.data.isNullOrEmpty()) emptyList() else it.data.take(3)
                    }

                    is Resource.Error -> {
                        _isProjectLoading.value = false
                        _error.value = it.message ?: "Error"
                    }
                }
            }
        }
    }
}