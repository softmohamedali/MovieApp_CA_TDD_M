package com.example.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {


    @Provides
    @ViewModelScoped
    fun provideDispatchers(): CoroutineDispatcher
    {
        return Dispatchers.IO

    }
}