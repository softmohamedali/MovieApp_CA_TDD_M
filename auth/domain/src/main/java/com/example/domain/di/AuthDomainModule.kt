package com.example.domain.di

import com.example.data.remote.FirebaseSource
import com.example.data.repo.AuthRepoImpl
import com.example.domain.repo.AuthRepo
import com.example.domain.usecases.LoginUseCase
import com.example.domain.usecases.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object AuthDomainModule {



    @Provides
    @Singleton
    fun provideAuthRepo(firebaseSource: FirebaseSource):AuthRepo
    {
        return AuthRepoImpl(firebaseSource)
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(authRepo: AuthRepo): LoginUseCase
    {
        return LoginUseCase(authRepo = authRepo)
    }

    @Provides
    @Singleton
    fun provideRegisterUseCase(authRepo: AuthRepo): RegisterUseCase
    {
        return RegisterUseCase(authRepo = authRepo)
    }

}