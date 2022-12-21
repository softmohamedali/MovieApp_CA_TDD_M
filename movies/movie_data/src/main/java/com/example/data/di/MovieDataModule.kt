package com.example.data.di

import com.example.data.remote.RemoteApi
import com.example.data.remote.RemoteConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient
    {
        return OkHttpClient().newBuilder()
            .callTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(RemoteConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): RemoteApi
    {
        return retrofit.create(RemoteApi::class.java)
    }
}