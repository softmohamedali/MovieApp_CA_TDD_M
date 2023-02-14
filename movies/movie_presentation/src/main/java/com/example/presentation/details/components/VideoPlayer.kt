package com.example.presentation.details.components

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
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
    val VIDEO_START_DELAY = 0F

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            factory = {
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                    webChromeClient = WebChromeClient()
                }
            },
            update = {
                it.loadUrl("https://www.youtube.com/watch?v=$videoId")
            },
            modifier = Modifier.fillMaxWidth().height(180.dp)
        )
    }
}



//
//@Composable
//fun YoutubeScreen(
//    videoId:String
//) {
//    val ctx = LocalContext.current
//    AndroidView(factory = {
//
//        var view=YouTubePlayerView(it)
//        val fragment = view.addYouTubePlayerListener(
//            object : AbstractYouTubePlayerListener() {
//
//                override fun onReady(youTubePlayer: YouTubePlayer) {
//                    super.onReady(youTubePlayer)
//                    youTubePlayer.loadVideo(videoId, 0f)
//                }
//
//
//            }
//        )
//
//        view
//    })
//}




