package com.cinurawa.propertioid.ui.pages.detail_project

import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailProjectViewModel
@Inject constructor(
    val player: Player
) : ViewModel() {

    var _videoUri = ""

    init {
        player.prepare()
    }

    fun addVideoUri(uri: String){
        _videoUri = uri
        player.addMediaItem(MediaItem.fromUri(_videoUri))
    }

    fun playVideo(){
        player.setMediaItem(MediaItem.fromUri(_videoUri))
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }

}