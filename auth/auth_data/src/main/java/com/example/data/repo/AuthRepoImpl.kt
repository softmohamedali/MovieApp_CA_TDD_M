package com.example.data.repo

import com.example.core.domain.models.ResultState
import com.example.core.domain.models.User
import com.example.data.remote.FirebaseSource
import com.example.domain.repo.AuthRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class AuthRepoImpl(
    private val firebaseSource: FirebaseSource
) :AuthRepo{


    private fun saveUser(user: User): ResultState<String> {
        var response: ResultState<String> = ResultState.IsError("Unknown Error Occurred")
        firebaseSource.saveUser(user)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    response= ResultState.IsSucsses(null)
                }else{
                    response= ResultState.IsError(it.exception?.message?:"Unknown Error")
                }
            }
        return response
    }

    override suspend fun registerUser(
        user: User,
        password: String
    ): ResultState<String> {
        var result: ResultState<String> = ResultState.IsError("Unknown Error Occurred")
        firebaseSource.createUserWithEmailANdPass(
            email = user.email,
            password = password
        ).addOnCompleteListener {
            if (it.isSuccessful){
                val responseSaveUser=saveUser(user)
                result=responseSaveUser
            }else{
                result= ResultState.IsError(it.exception?.message?:"Unknown Error")
            }
        }
        return result
    }

    override suspend fun logIn(
        email: String,
        password: String
    ): ResultState<String> {
        var result: ResultState<String> = ResultState.IsError("Unknown Error")
        firebaseSource.singInWithEmail(
            email = email,
            password = password
        ).addOnCompleteListener {
            if (it.isSuccessful){
                result= ResultState.IsSucsses(null)
            }else{
                result= ResultState.IsError(it.exception?.message?:"Unknown Error")
            }
        }
        return result
    }

    override suspend fun logout() {
        firebaseSource.logOut()
    }

    override fun getCurrentUser(): String? {
        return firebaseSource.currentUser()
    }


}