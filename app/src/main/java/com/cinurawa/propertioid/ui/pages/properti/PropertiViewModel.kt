package com.cinurawa.propertioid.ui.pages.properti

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.utils.DataProvider
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertiViewModel
@Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

    private var _listProperty = MutableStateFlow<List<Property>>(emptyList())
    val listProperty = _listProperty

    private var _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading

    private var _error = MutableStateFlow("")
    val error = _error

    val listPropertyType = DataProvider.listPropertyType
    var keyword = mutableStateOf("")
    var propertyType = mutableStateOf("")
    var listingType = mutableStateOf("")
    var isSearch = mutableStateOf(false)

    fun setQuery(keyword: String, propertyType: String, listingType: String) {
        if (keyword == "default" && propertyType == "default" && listingType == "default") {
            getListProperty()
            isSearch.value = false
            return
        }
        isSearch.value = true
        this.keyword.value = if (keyword == "default") "" else keyword
        this.propertyType.value = if (propertyType == "default") "" else propertyType
        this.listingType.value = if (listingType == "default") "" else listingType
        getSearchProperty()
    }


    private fun getListProperty() {
        viewModelScope.launch {
            repo.getAllProperty().collect {
                when (it) {
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

    private fun getSearchProperty() {
        viewModelScope.launch {
            repo.getAllProperty(
                keyword = keyword.value,
                propertyType = propertyType.value,
                listingType = listingType.value
            ).collect {
                when (it) {
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
}