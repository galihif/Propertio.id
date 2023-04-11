package com.cinurawa.propertioid.ui.pages.detail_project

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import com.cinurawa.propertioid.ui.utils.getPlayableYoutubeUrl
import com.cinurawa.propertioid.utils.formatGmapsUri
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailProjectViewModel
@Inject constructor(
    val player: Player
) : ViewModel() {

    private var _videoUri = ""

    private var _locationName = ""
    private var _latitude = 0.0
    private var _longitude = 0.0

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

    override fun onCleared() {
        super.onCleared()
        player.release()
    }

}