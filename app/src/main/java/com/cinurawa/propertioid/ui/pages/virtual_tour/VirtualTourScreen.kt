package com.cinurawa.propertioid.ui.pages.virtual_tour

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun VirtualTourScreen(
    urlId:Int,
) {
    val url = "https://virtualtour0001.propertio.id/"
    val webClient = remember {
        object : AccompanistWebViewClient() {
            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: Bitmap?
            ) {
                super.onPageStarted(view, url, favicon)
                Log.d("Accompanist WebView", "Page started loading for $url")
            }
        }
    }

    val state = rememberWebViewState(url = url)
    WebView(
        state = state,
        modifier = Modifier
            .fillMaxSize(),
        onCreated = { webView ->
            webView.settings.javaScriptEnabled = true
            webView.settings.useWideViewPort = true
        },
        client = webClient
    )
}