package com.cinurawa.propertioid.ui.utils

import android.annotation.SuppressLint
import android.content.Context
import android.util.SparseArray
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile

fun getPlayableYoutubeUrl(context: Context, uri: String, onCallback: (String) -> Unit) {
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
                onCallback(videoUrl)
            }
        }

    }.extract(uri)
}