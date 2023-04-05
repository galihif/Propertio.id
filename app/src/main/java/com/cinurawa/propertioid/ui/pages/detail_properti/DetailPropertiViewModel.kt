package com.cinurawa.propertioid.ui.pages.detail_properti

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.SparseArray
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailPropertiViewModel
@Inject constructor(
    val player: Player
) : ViewModel() {

    private var _videoUri = ""

    private var _latitude = 0.0
    private var _longitude = 0.0

    fun addLatLong(latitude: Double, longitude: Double){
        _latitude = latitude
        _longitude = longitude
    }

    fun openMap(context: Context){
        val mapUri: Uri = Uri.parse("geo:$_latitude,$_longitude?z=20")
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        context.startActivity(mapIntent)
    }

    init {
        player.prepare()
    }

    @SuppressLint("StaticFieldLeak")
    fun addVideoUri(uri: String, context: Context){
        object : YouTubeExtractor(context) {
            @SuppressLint("UnsafeOptInUsageError")
            override fun onExtractionComplete(
                ytFiles: SparseArray<YtFile>?,
                videoMeta: VideoMeta?
            ) {
                if (ytFiles != null) {

                    val iTag = 137//tag of video 1080
                    // 720, 1080, 480
                    var videoUrl = ""
                    val iTags: List<Int> = listOf(22, 137, 18)
                    for (i in iTags) {
                        val ytFile = ytFiles.get(i)
                        if (ytFile != null) {
                            val downloadUrl = ytFile.url
                            if (downloadUrl != null && downloadUrl.isNotEmpty()) {
                                videoUrl = downloadUrl
                            }
                        }
                    }
                    if (videoUrl == "")
                        videoUrl = ytFiles[iTag].url
                    _videoUri = videoUrl
                    player.setMediaItem(MediaItem.fromUri(videoUrl))
                }
            }

        }.extract(uri)
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }

}