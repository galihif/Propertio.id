package com.cinurawa.propertioid.ui.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepositoryImpl
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repo: MainRepositoryImpl
) : ViewModel() {

    private var _listProperty = MutableStateFlow<List<Property>>(emptyList())
    val listProperty = _listProperty

    private var _listProject = MutableStateFlow<List<Project>>(emptyList())
    val listProject = _listProject

    private var _isPropertyLoading = MutableStateFlow(true)
    val isPropertyLoading = _isPropertyLoading

    private var _isProjectLoading = MutableStateFlow(true)
    val isProjectLoading = _isProjectLoading

    private var _error = MutableStateFlow("")
    val error = _error

    private fun getListProperty() {
        viewModelScope.launch {
            repo.getAllProperty().collect {
                when (it) {
                    is Resource.Loading -> {
                        _isPropertyLoading.value = true
                    }
                    is Resource.Success -> {
                        _isPropertyLoading.value = false
                        _listProperty.value =
                            if (it.data.isNullOrEmpty()) emptyList() else it.data.take(3)
                    }
                    is Resource.Error -> {
                        _isPropertyLoading.value = false
                        _error.value = it.message ?: "Error"
                    }
                }
            }
        }
    }

    private fun getListProject() {
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

    init {
        getListProperty()
        getListProject()
    }
}