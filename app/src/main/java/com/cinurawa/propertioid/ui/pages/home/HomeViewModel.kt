package com.cinurawa.propertioid.ui.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.remote.dto.GetAllPropertyDto
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

    var _listProperty = MutableStateFlow<List<GetAllPropertyDto.PropertyData>>(emptyList())
    val listProperty = _listProperty

    var _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading

    var _error = MutableStateFlow("")
    val error = _error

    private fun getListProperty(){
        viewModelScope.launch {
            repo.getAllProperty().collect {
                when(it){
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Success -> {
                        _isLoading.value = false
                        _listProperty.value = if (it.data.isNullOrEmpty()) emptyList() else it.data
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
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