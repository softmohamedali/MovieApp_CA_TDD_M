package com.example.core.ui


import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)



val black = Color(0xFF000000)
val bloack_05 = Color(0x8D000000)
val white = Color(0xFFFFFFFF)
val my_blue= Color(0xFF388EFF)
val icon_selcted=Color(0xFF388EFF)
val icon_un_selcted=Color(0xFF798596)


val Colors.main_color
    @Composable
    get() =my_blue

val Colors.loding_layer
    @Composable
    get() =bloack_05

val Colors.title
    @Composable
    get() = if (isLight) black else black.copy(alpha = 0.5f)

val Colors.text_faild_back
    @Composable
    get() = if (isLight) white else black.copy(alpha = 0.5f)

val Colors.icon_bottom_bar
    @Composable
    get() = if (isLight) icon_selcted else black.copy(alpha = 0.5f)

val Colors.icon_bottom_bar_unselected
    @Composable
    get() = if (isLight) icon_un_selcted else white.copy(alpha = 0.5f)