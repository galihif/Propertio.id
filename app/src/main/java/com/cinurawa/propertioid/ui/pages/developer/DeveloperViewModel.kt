package com.cinurawa.propertioid.ui.pages.developer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.model.Developer
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeveloperViewModel 
@Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

    private var _listDeveloper = MutableStateFlow<List<Developer>>(emptyList())
    val listDeveloper = _listDeveloper

    private var _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading

    private var _error = MutableStateFlow("")
    val error = _error

    private fun getListDeveloper(){
        viewModelScope.launch {
            repo.getAllDeveloper().collect {
                when(it){
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Success -> {
                        _isLoading.value = false
                        if (it.data != null){
                            _listDeveloper.value = it.data
                        }
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
        getListDeveloper()
    }
}