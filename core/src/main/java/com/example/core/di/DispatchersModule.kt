package com.example.core.di

import android.content.Context
import com.example.core.data.connectivity.NetworkConnectivityObserver
import com.example.core.domain.qulifier.IODispatchers
import com.example.core.domain.qulifier.MainDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@InstallIn(ViewModelComponent::class)
@Module
object DispatchersModule {

    @IODispatchers
    @Provides
    @ViewModelScoped
    fun provideIoDispatchers():CoroutineDispatcher=Dispatchers.IO


    @MainDispatchers
    @Provides
    @ViewModelScoped
    fun provideMainDispatchers():CoroutineDispatcher=Dispatchers.Main



}