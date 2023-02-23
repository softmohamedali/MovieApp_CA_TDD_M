package com.example.data.local

import androidx.room.*
import com.example.data.local.localdto.ActorLocal
import com.example.data.local.localdto.MovieLocal
import com.example.data.local.localdto.SeriesLocal
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavMovie(movie:MovieLocal)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavSeries(series:SeriesLocal)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavActor(actor:ActorLocal)

    @Delete
    suspend fun deleteFavMovie(movie:MovieLocal)
    @Delete
    suspend fun deleteFavSeries(series:SeriesLocal)
    @Delete
    suspend fun deleteFavActor(actor:ActorLocal)

    @Query("SELECT * FROM movie")
    fun getFavMovies():Flow<List<MovieLocal>>
    @Query("SELECT * FROM series")
    fun getFavSeries():Flow<List<SeriesLocal>>
    @Query("SELECT * FROM actors")
    fun getFavActor():Flow<List<ActorLocal>>



}