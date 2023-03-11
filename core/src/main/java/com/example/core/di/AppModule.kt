package com.example.core.di

import android.app.Application
import android.content.Context
import coil.ImageLoader
import com.example.core.data.connectivity.NetworkConnectivityObserver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideImageLoader(@ApplicationContext app: Application): ImageLoader {
        return ImageLoader.Builder(app)
            .crossfade(true)
            .componentRegistry {

            }
            .build()
    }


    @Provides
    @Singleton
    fun provideConnectivityObserver(@ApplicationContext app: Context):NetworkConnectivityObserver {
        return NetworkConnectivityObserver(app)
    }





}