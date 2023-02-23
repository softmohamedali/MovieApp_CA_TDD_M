package com.example.data.mapper

import com.example.data.local.localdto.ActorLocal
import com.example.data.remote.dto.actors.RemoteActor
import com.example.data.remote.dto.actors.RemoteOneActor
import com.example.domin.models.Actor
import com.example.domin.models.ActorItem


fun RemoteOneActor.toActorItem(): ActorItem {
    return ActorItem(
        adult = this.adult,
        gender = this.gender,
        id = this.id,
        knownForDepartment = this.knownForDepartment?:"",
        name = this.name,
        popularity = this.popularity,
        profilePath = this.profilePath?:""
    )
}

fun List<RemoteOneActor>.toListActorItems(): List<ActorItem> {
    return this.map { it.toActorItem() }
}

fun RemoteActor.toActor(): Actor {
    return Actor(
        adult = this.adult,
        gender = this.gender,
        id = this.id,
        knownForDepartment = this.knownForDepartment,
        name = this.name,
        popularity = this.popularity,
        profilePath = this.profilePath?:"",
        alsoKnownAs = this.alsoKnownAs,
        biography = this.biography,
        birthday = this.birthday,
        deathday = this.deathday,
        homepage = this.homepage,
        imdbId = this.imdbId,
        placeOfBirth = this.placeOfBirth,
    )
}




//------------------------local
fun ActorLocal.toActor(): Actor {
    return Actor(
        adult = this.adult,
        gender = this.gender,
        id = this.id,
        knownForDepartment = this.knownForDepartment,
        name = this.name,
        popularity = this.popularity,
        profilePath = this.profilePath?:"",
        alsoKnownAs = this.alsoKnownAs,
        biography = this.biography,
        birthday = this.birthday,
        deathday = this.deathday,
        homepage = this.homepage,
        imdbId = this.imdbId,
        placeOfBirth = this.placeOfBirth,
    )
}


fun Actor.toActorLocal(): ActorLocal {
    return ActorLocal(
        adult = this.adult,
        gender = this.gender,
        id = this.id,
        knownForDepartment = this.knownForDepartment,
        name = this.name,
        popularity = this.popularity,
        profilePath = this.profilePath?:"",
        alsoKnownAs = this.alsoKnownAs,
        biography = this.biography,
        birthday = this.birthday,
        deathday = this.deathday,
        homepage = this.homepage,
        imdbId = this.imdbId,
        placeOfBirth = this.placeOfBirth,
    )
}


fun List<ActorLocal>.toListActor(): List<Actor> {
    return this.map { it.toActor() }
}


