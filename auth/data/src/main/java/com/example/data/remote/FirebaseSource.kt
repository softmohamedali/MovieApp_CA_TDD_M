package com.example.data.remote

import com.example.core.domain.models.User
import com.example.data.utils.Constatns
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject


class FirebaseSource  @Inject constructor(
    private val auth: FirebaseAuth,
    private val fireStore: FirebaseFirestore
){

    fun createUserWithEmailANdPass(email:String,password:String)=
        auth.createUserWithEmailAndPassword(email,password)

    fun saveUser(user: User)=fireStore.collection(Constatns.USERS_COLLECTION)
            .document().set(user)

    fun singInWithEmail(email:String,password: String)=
        auth.signInWithEmailAndPassword(email, password)

    fun logOut()=auth.signOut()

    fun currentUser():String?=auth.currentUser?.email
    
}

