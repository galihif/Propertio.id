package com.cinurawa.propertioid.ui.pages.detail_properti

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.model.emptyProperty
import com.cinurawa.propertioid.ui.utils.IntentHelper
import com.cinurawa.propertioid.ui.utils.formatGmapsUri
import com.cinurawa.propertioid.ui.utils.formatHarga
import com.cinurawa.propertioid.ui.utils.formatShareMessage
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailPropertiViewModel
@Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

    private var _locationName = ""
    private var _latitude = 0.0
    private var _longitude = 0.0

    private var _slug = ""
    private var _property = MutableStateFlow(emptyProperty())
    val property = _property
    private var _loading = MutableStateFlow(false)
    val loading = _loading
    private var _error = MutableStateFlow("")
    val error = _error
    fun setSlug(slug: String) {
        _slug = slug
        getDetailProperty()
    }

    private fun getDetailProperty() {
        viewModelScope.launch {
            repo.getDetailProperty(_slug).collect {
                when (it) {
                    is Resource.Loading -> {
                        _loading.value = true
                    }

                    is Resource.Success -> {
                        _loading.value = false
                        if (it.data != null) {
                            _property.value = it.data
                        }
                    }

                    is Resource.Error -> {
                        _loading.value = false
                        _error.value = it.message ?: "Error"
                    }
                }
            }
        }
    }

    fun addLocation(locationName: String, latitude: Double, longitude: Double) {
        _locationName = locationName
        _latitude = latitude
        _longitude = longitude
    }

    fun openMap(context: Context) {
        IntentHelper.openMaps(context, formatGmapsUri(_locationName, _latitude, _longitude))
    }

    fun openDokumen(context: Context, link: String) {
        IntentHelper.openDokumen(context, link)
    }

    fun openWhatsapp(context: Context, number: String) {
        IntentHelper.openWhatsapp(context, number)
    }

    fun callNumber(context: Context, number: String) {
        IntentHelper.callNumber(context, number)
    }

    fun shareProperty(context: Context) {
        val propertyName = _property.value.name
        val propertyPrice = formatHarga(_property.value.price.toLong())
        IntentHelper.shareToApps(context, formatShareMessage(propertyName, propertyPrice, _slug))
    }
}