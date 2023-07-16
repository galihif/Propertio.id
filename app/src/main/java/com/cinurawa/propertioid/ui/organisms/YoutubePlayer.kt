package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun YoutubePlayer(
    videoId: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val youTubePlayerView = remember { YouTubePlayerView(context) }

    DisposableEffect(lifecycle) {
        lifecycle.addObserver(youTubePlayerView)
        onDispose {
            lifecycle.removeObserver(youTubePlayerView)
            youTubePlayerView.release()
        }
    }

    AndroidView(
        factory = {
            youTubePlayerView
        },
        update = { view ->
            view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.cueVideo(videoId, 0f) // use cueVideo instead of loadVideo
                }
            })
        },
        modifier = modifier.clip(RoundedCornerShape(8.dp))
    )
}