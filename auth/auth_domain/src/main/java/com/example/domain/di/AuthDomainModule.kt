package com.example.domain.di

import com.example.domain.repo.AuthRepo
import com.example.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object AuthDomainModule {






    @ViewModelScoped
    @Provides
    fun provideLoginUseCase(authRepo: AuthRepo): LoginUseCase
    {
        return LoginUseCase(authRepo = authRepo)
    }

    @ViewModelScoped
    @Provides
    fun provideRegisterUseCase(authRepo: AuthRepo): RegisterUseCase
    {
        return RegisterUseCase(authRepo = authRepo)
    }

    @ViewModelScoped
    @Provides
    fun provideValidateEmailUseCase(): ValidateEmailUseCase
    {
        return ValidateEmailUseCase()
    }


    @ViewModelScoped
    @Provides
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase
    {
        return ValidatePasswordUseCase()
    }

    @ViewModelScoped
    @Provides
    fun provideConfirmPasswordUseCase(): ValidateConfirmPasswordUseCase
    {
        return ValidateConfirmPasswordUseCase()
    }

    @ViewModelScoped
    @Provides
    fun provideValidateAccepteTermsUseCase(): ValidateAccepteTermsUseCase
    {
        return ValidateAccepteTermsUseCase()
    }





}