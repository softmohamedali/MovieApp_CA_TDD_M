package com.example.data.di

import com.example.data.remote.FirebaseSource
import com.example.data.repo.AuthRepoImpl
import com.example.domain.repo.AuthRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth():FirebaseAuth
    {
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseFirestore():FirebaseFirestore
    {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseSource(
        auth: FirebaseAuth,
        firestore: FirebaseFirestore
    ):FirebaseSource
    {
        return FirebaseSource(auth,firestore)
    }



    @Singleton
    @Provides
    fun provideAuthRepo(
        firebaseSource: FirebaseSource
    ):AuthRepo =AuthRepoImpl(firebaseSource = firebaseSource)



}