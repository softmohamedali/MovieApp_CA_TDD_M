package com.example.core.domain.connectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observer():Flow<ConnectivityStatus>

    enum class ConnectivityStatus{
        AVAILABLE,UNAVAILABLE,ISLOSING,LOST
    }
}