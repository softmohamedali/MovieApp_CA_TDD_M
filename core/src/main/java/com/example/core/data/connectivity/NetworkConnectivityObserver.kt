package com.example.core.data.connectivity

import com.example.core.domain.connectivity.ConnectivityObserver
import kotlinx.coroutines.flow.Flow

class NetworkConnectivityObserver:ConnectivityObserver {
    override fun observer(): Flow<ConnectivityObserver.ConnectivityStatus> {

    }
}