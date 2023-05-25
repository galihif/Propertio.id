package com.cinurawa.propertioid.ui.pages.detail_project

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.data.model.getEmptyProject
import com.cinurawa.propertioid.ui.utils.IntentHelper
import com.cinurawa.propertioid.ui.utils.formatGmapsUri
import com.cinurawa.propertioid.ui.utils.formatHarga
import com.cinurawa.propertioid.ui.utils.formatShareMessage
import com.cinurawa.propertioid.ui.utils.getPlayableYoutubeUrl
import com.cinurawa.propertioid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailProjectViewModel
@Inject constructor(
    val player: Player,
    private val repo: MainRepository
) : ViewModel() {

    private var _videoUri = ""

    private var _locationName = ""
    private var _latitude = 0.0
    private var _longitude = 0.0

    private var _slug = ""

    private var _project = MutableStateFlow(getEmptyProject())
    val project = _project

    private var _loading = MutableStateFlow(false)
    val loading = _loading

    private var _error = MutableStateFlow("")
    val error = _error

    fun setSlug(slug: String){
        _slug = slug
        getDetailProject()
    }

    private fun getDetailProject(){
        viewModelScope.launch {
            repo.getDetailProject(_slug).collect{
                when(it){
                    is Resource.Loading -> {
                        loading.value = true
                    }
                    is Resource.Success -> {
                        _loading.value = false
                        if (it.data != null) {
                            _project.value = it.data
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

    fun addLocation(locationName:String,latitude: Double, longitude: Double){
        _locationName = locationName
        _latitude = latitude
        _longitude = longitude
    }

    fun openMap(context: Context){
        val mapUri: Uri = formatGmapsUri(_locationName,_latitude,_longitude)
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        context.startActivity(mapIntent)
    }

    init {
        player.prepare()
    }

    @SuppressLint("StaticFieldLeak")
    fun addVideoUri(uri: String, context: Context){
        getPlayableYoutubeUrl(context, uri) {
            _videoUri = it
            player.addMediaItem(MediaItem.fromUri(_videoUri))
        }
    }
    fun openDokumen(context: Context,link:String){
        IntentHelper.openDokumen(context,link)
    }
    fun openWhatsapp(context: Context, number: String){
        IntentHelper.openWhatsapp(context,number)
    }
    fun callNumber(context: Context, number: String){
        IntentHelper.callNumber(context,number)
    }
    override fun onCleared() {
        super.onCleared()
        player.release()
    }

    fun shareProject(context: Context) {
        val projectName = project.value.name
        val startPrice = formatHarga(project.value.startPrice.toLong())
        val endPrice = formatHarga(project.value.finalPrice.toLong())
        val message = formatShareMessage(projectName,startPrice,endPrice,_slug)
        IntentHelper.shareToApps(context,message)
    }

}