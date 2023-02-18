package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local.localdto.ActorLocal
import com.example.data.local.localdto.MovieLocal
import com.example.data.local.localdto.SeriesLocal

@Database(
    entities = [ActorLocal::class,MovieLocal::class,SeriesLocal::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(MyDataConverters::class)
abstract class MovieDataBase: RoomDatabase() {

    abstract fun myDao():MovieDao

}