package com.example.data.local.localdto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domin.utils.MovieDomainConstants


@Entity(tableName = MovieDomainConstants.ACTOR_ENTITY_NAME)
@kotlinx.serialization.Serializable
data class ActorLocal(
    val adult: Boolean,
    val alsoKnownAs: List<String>,
    val biography: String,
    val birthday: String,
    val deathday: String?,
    val gender: Int,
    val homepage: String?,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val imdbId: String,
    val knownForDepartment: String,
    val name: String,
    val placeOfBirth: String,
    val popularity: Double,
    val profilePath: String
)