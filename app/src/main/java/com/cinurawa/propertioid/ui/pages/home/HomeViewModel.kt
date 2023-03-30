package com.cinurawa.propertioid.ui.pages.home

import androidx.lifecycle.ViewModel
import com.cinurawa.propertioid.data.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repo: MainRepository
) : ViewModel() {
    val _tes = MutableStateFlow("")

    fun getTest() {
        _tes.value = repo.tes
    }

    init {
        getTest()
    }
}