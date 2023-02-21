package com.example.data.local

import androidx.room.TypeConverter
import com.example.domin.models.GenreMovie
import com.example.domin.models.GenreSeries
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyDataConverters {

    val json= Gson()

    @TypeConverter
    fun listStringTOString(list:List<String>):String
    {
        return json.toJson(list)
    }

    @TypeConverter
    fun stringTOListString(string:String):List<String>
    {
        return json.fromJson(string,object : TypeToken<List<String>>(){}.type)
    }


    @TypeConverter
    fun listIntTOString(list:List<Int>):String
    {
        return json.toJson(list)
    }

    @TypeConverter
    fun stringTOListInt(string:String):List<Int>
    {
        return json.fromJson(string,object : TypeToken<List<Int>>(){}.type)
    }

    @TypeConverter
    fun stringTOListMovieGenere(string:String):List<GenreMovie>
    {
        return json.fromJson(string,object : TypeToken<List<GenreMovie>>(){}.type)
    }

    @TypeConverter
    fun lisGenreToString(list:List<GenreMovie>):String
    {
        return json.toJson(list)
    }


    @TypeConverter
    fun stringTOListSeriesGenere(string:String):List<GenreSeries>
    {
        return json.fromJson(string,object : TypeToken<List<GenreSeries>>(){}.type)
    }

    @TypeConverter
    fun listSeriesGenreToString(list:List<GenreSeries>):String
    {
        return json.toJson(list)
    }
}