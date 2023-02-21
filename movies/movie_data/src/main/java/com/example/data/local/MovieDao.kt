package com.example.data.local

import androidx.room.*
import com.example.data.local.localdto.ActorLocal
import com.example.data.local.localdto.MovieLocal
import com.example.data.local.localdto.SeriesLocal
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavMovie(movie:MovieLocal)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavSeries(movie:SeriesLocal)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavActor(movie:ActorLocal)

    @Delete
    fun deleteFavMovie(movie:MovieLocal)
    @Delete
    fun deleteFavSeries(movie:SeriesLocal)
    @Delete
    fun deleteFavActor(movie:ActorLocal)

    @Query("SELECT * FROM movie")
    fun getFavMovies():Flow<List<MovieLocal>>
    @Query("SELECT * FROM series")
    fun getFavSeries():Flow<List<SeriesLocal>>
    @Query("SELECT * FROM actors")
    fun getFavActor():Flow<List<ActorLocal>>



}