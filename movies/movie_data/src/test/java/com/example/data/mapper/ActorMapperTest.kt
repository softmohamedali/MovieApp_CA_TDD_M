package com.example.data.mapper

import com.example.data.remote.dto.actors.RemoteActor
import com.example.domin.models.Actor
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ActorMapperTest {

    @Test
    fun `remoteActor() toActor should map the same object`(){
        val remoteActor=RemoteActor(
            adult= false,
            alsoKnownAs= listOf<Any>(),
            biography= "String",
            birthday= "String",
            deathday= "Any",
            gender= -1,
            homepage= "Any",
            id= -1,
            imdbId= "String",
            knownForDepartment= "String",
            name= "String",
            placeOfBirth= "Any",
            popularity= 0.0,
            profilePath= ""
        )

        val actor=Actor(
            adult= false,
            alsoKnownAs= listOf<Any>(),
            biography= "String",
            birthday= "String",
            deathday= "Any",
            gender= -1,
            homepage= "Any",
            id= -1,
            imdbId= "String",
            knownForDepartment= "String",
            name= "String",
            placeOfBirth= "Any",
            popularity= 0.0,
            profilePath= ""
        )
        assertThat(remoteActor.toActor()).isEqualTo(actor)
    }
}