package com.cinurawa.propertioid.ui.pages.detail_developer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepositoryImpl
import com.cinurawa.propertioid.data.model.Developer
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailDeveloperViewModel
@Inject constructor(
    private val repo:MainRepositoryImpl
) : ViewModel() {
    private var _id = 0

    private var _developer = MutableStateFlow(Developer())
    val developer = _developer

    private var _loading = MutableStateFlow(false)
    val loading = _loading

    private var _error = MutableStateFlow("")
    val error = _error

    fun setId(id:Int){
        _id = id
        getDetailAgent()
    }

    private fun getDetailAgent(){
        viewModelScope.launch {
            repo.getDetailDeveloper(_id)
                .collect{
                    when(it){
                        is Resource.Loading -> {
                            _loading.value = true
                        }
                        is Resource.Success -> {
                            _loading.value = false
                            if (it.data != null){
                                _developer.value = it.data
                            }
                        }
                        is Resource.Error -> {
                            _loading.value = false
                            _error.value = it.message?:"Error"
                        }
                    }
                }
        }
    }
}