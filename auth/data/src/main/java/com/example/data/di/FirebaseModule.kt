package com.example.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth():FirebaseAuth
    {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseFirestore():FirebaseFirestore
    {
        return FirebaseFirestore.getInstance()
    }
}