package com.cinurawa.propertioid.ui.pages.agent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepositoryImpl
import com.cinurawa.propertioid.data.model.Agent
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentViewModel
@Inject constructor(
    private val repo:MainRepositoryImpl
) : ViewModel() {

    private var _listAgent = MutableStateFlow<List<Agent>>(emptyList())
    val listAgent = _listAgent

    private var _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading

    private var _error = MutableStateFlow("")
    val error = _error

    private fun getListAgent(){
        viewModelScope.launch {
            repo.getAllAgent().collect{
                when(it){
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Success -> {
                        _isLoading.value = false
                        if (it.data != null) it.data.also { res -> _listAgent.value = res }
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
        getListAgent()
    }

}