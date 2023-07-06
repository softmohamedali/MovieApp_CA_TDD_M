package com.example.presentation.details.components

import android.webkit.WebSettings.PluginState
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView


@Composable
fun VideoView(
    videoUri: String,
    modifier: Modifier
) {
    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(LocalContext.current)
        .build()
        .also { exoPlayer ->
            val mediaItem = MediaItem.Builder()
                .setUri(videoUri)
                .build()
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }

    DisposableEffect(
        AndroidView(
            modifier = modifier.fillMaxWidth(),
            factory = {
            StyledPlayerView(context).apply {
                player = exoPlayer
            }
        })
    ) {
        onDispose { exoPlayer.release() }
    }
}


@Composable
fun YoutubeScreen(
    videoId:String
) {

    val context = LocalContext.current
    val widthAndHeight = "width='220' height='200'"
    val temp = "<html><body><iframe width=\"360\" height=\"180\" src=\"https://www.youtube.com/embed/${videoId}\" frameborder=\"0\" allowfullscreen></iframe></body></html>"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            factory = {
                WebView(context).apply {
                    settings.setPluginState(PluginState.ON)
                    settings.setJavaScriptEnabled(true)
                    settings.setJavaScriptCanOpenWindowsAutomatically(false)
//                    settings.setPluginsEnabled(true)
                    settings.setSupportMultipleWindows(false)
                    settings.setSupportZoom(false)
                    setVerticalScrollBarEnabled(false)
                    setHorizontalScrollBarEnabled(false)

                }
            },
            update = {
                it.loadData(temp,"text/html", "utf-8")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}







