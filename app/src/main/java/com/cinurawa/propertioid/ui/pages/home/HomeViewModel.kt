package com.cinurawa.propertioid.ui.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

    private var _listProperty = MutableStateFlow<List<Property>>(emptyList())
    val listProperty = _listProperty

    private var _isPropertyLoading = MutableStateFlow(true)
    val isPropertyLoading = _isPropertyLoading

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


    init {
        getListProperty()
    }
}