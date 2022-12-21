package com.example.data.repo

import com.example.core.domain.models.ResultState
import com.example.core.domain.models.User
import com.example.core.domain.utils.log
import com.example.data.remote.FirebaseSource
import com.example.domain.repo.AuthRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class AuthRepoImpl @Inject constructor(
    private val firebaseSource: FirebaseSource
) :AuthRepo{


    private fun saveUser(user: User,result:(ResultState<String>)->Unit){
        firebaseSource.saveUser(user)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    result(ResultState.IsSucsses(null))
                }else{
                    result(ResultState.IsError(it.exception?.message?:"Unknown Error"))
                }
            }
    }

    override suspend fun registerUser(
        user: User,
        password: String,
        result:(ResultState<String>)->Unit
    ){
        log("registerUser repo")
        firebaseSource.createUserWithEmailANdPass(
            email = user.email,
            password = password
        ).addOnCompleteListener {
            if (it.isSuccessful){
                saveUser(user) {result ->
                    result(result)
                }
            }else{
                result(ResultState.IsError(it.exception?.message?:"Unknown Error"))
            }
        }
    }

    override suspend fun logIn(
        email: String,
        password: String,
        result:(ResultState<String>)->Unit
    ){
        firebaseSource.singInWithEmail(
            email = email,
            password = password
        ).addOnCompleteListener {
            if (it.isSuccessful){
                result(ResultState.IsSucsses(null))
            }else{
                result(ResultState.IsError(it.exception?.message?:"Unknown Error"))
            }
        }
    }

    override suspend fun logout() {
        firebaseSource.logOut()
    }

    override fun getCurrentUser(): String? {
        return firebaseSource.currentUser()
    }


}