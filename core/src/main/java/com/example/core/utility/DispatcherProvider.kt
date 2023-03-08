package com.example.core.utility

import android.graphics.Bitmap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


interface DispatcherProvider {

    val main
        get() = Dispatchers.Main
    val default
        get() = Dispatchers.Default
    val io
        get() = Dispatchers.IO
    val unconfined
        get() = Dispatchers.Unconfined
}

class DefaultDispatcherProvider : DispatcherProvider

class TestDispatcherProvider(
    private val testDispatcher:  = ()
) : DispatcherProvider {
    override val default: CoroutineDispatcher
        get() = testDispatcher
    override val io
        get() = testDispatcher
    override val main
        get() = testDispatcher
    override val unconfined
        get() = testDispatcher
}