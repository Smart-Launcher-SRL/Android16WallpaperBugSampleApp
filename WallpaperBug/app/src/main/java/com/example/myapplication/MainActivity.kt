package com.example.myapplication

import android.app.WallpaperManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {

    private lateinit var wallpaperManager: WallpaperManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wallpaperManager = WallpaperManager.getInstance(this)
        enableEdgeToEdge()
        setContent {
            Column(
                Modifier
                    .fillMaxSize()
                    .systemBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(onClick = { setWallpaper() }) {
                    Text("Set sample wallpaper")
                }
                Button(onClick = { applyOffset(0f) }) {
                    Text("Align to left (0f)")
                }
                Button(onClick = { applyOffset(0.5f) }) {
                    Text("Center wallpaper (0.5f)")
                }
                Button(onClick = { applyOffset(1f) }) {
                    Text("Align to right (1f)")
                }
            }
        }

    }

    private fun setWallpaper() {
        wallpaperManager.setResource(R.raw.sample_wallpaper)
    }

    private fun applyOffset(offset: Float) {
        wallpaperManager.setWallpaperOffsetSteps(0.5f, 0.5f)
        wallpaperManager.setWallpaperOffsets(window.decorView.rootView.windowToken, offset, 0.5f)
    }

}
