package com.example.data.local

import androidx.room.TypeConverter
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
}