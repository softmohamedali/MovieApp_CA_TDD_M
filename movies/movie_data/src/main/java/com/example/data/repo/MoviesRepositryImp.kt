package com.example.data.repo

import com.example.data.remote.RemoteConstants
import com.example.data.remote.RemoteMovieApi
import javax.inject.Inject

class MoviesRepositryImp @Inject constructor(
    private val remoteMovieApi: RemoteMovieApi
){

}




class H{
    fun applyPopularMovie():HashMap<String,String>{
        val query:HashMap<String,String> =HashMap()
        query[RemoteConstants.QUERY_API_KEY]= RemoteConstants.API_KEY
        query["page"]="1"
        query[RemoteConstants.SORTBY_KEY]="popularity.desc"
        return query
    }

    fun applyPopularSeries():HashMap<String,String>{
        val query:HashMap<String,String> =HashMap()
        query[RemoteConstants.QUERY_API_KEY]= RemoteConstants.API_KEY
        query["page"]="2"
        query[RemoteConstants.SORTBY_KEY]="popularity.desc"
        return query
    }

    fun applyPopularPeople():HashMap<String,String>{
        val query:HashMap<String,String> =HashMap()
        query[RemoteConstants.QUERY_API_KEY]= RemoteConstants.API_KEY
        query["page"]="1"
        return query
    }
    fun applyApiKey():HashMap<String,String>{
        val query:HashMap<String,String> =HashMap()
        query[RemoteConstants.QUERY_API_KEY]= RemoteConstants.API_KEY
        return query
    }
    fun appluQueri(page:String):HashMap<String,String> {
        val map=HashMap<String,String>()
        map[RemoteConstants.QUERY_API_KEY]= RemoteConstants.API_KEY
        map["page"]=page
        return map
    }
    fun appluSearchQueri(queryy:String,page:String):HashMap<String,String> {
        val query:HashMap<String,String> =HashMap()
        query[RemoteConstants.QUERY_API_KEY]= RemoteConstants.API_KEY
        query["query"]=queryy
        query["page"]=page
        return query
    }
}