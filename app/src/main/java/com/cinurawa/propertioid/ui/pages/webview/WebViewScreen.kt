package com.cinurawa.propertioid.ui.pages.webview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(
    url: String,
) {
    val webClient = remember {
        object : AccompanistWebViewClient() {
            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: Bitmap?
            ) {
                super.onPageStarted(view, url, favicon)
            }
        }
    }

    val state = rememberWebViewState(url = url)
    Column {
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                )
            }
        }
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
}