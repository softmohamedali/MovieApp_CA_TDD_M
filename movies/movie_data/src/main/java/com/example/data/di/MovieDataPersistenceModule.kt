package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.MovieDao
import com.example.data.local.MovieDataBase
import com.example.data.remote.RemoteConstants
import com.example.domin.utils.MovieDomainConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieDataPersistenceModule {
    @Provides
    @Singleton
    fun provideMovieDataBase(@ApplicationContext context:Context): MovieDataBase
    {
        return Room.databaseBuilder(
            context,
            MovieDataBase::class.java,
            MovieDomainConstants.MOVIE_DATABASE_NAME
        ) .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database:MovieDataBase): MovieDao
    {
        return database.myDao()
    }
}