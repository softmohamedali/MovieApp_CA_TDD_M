package com.example.domin.models

import com.example.domin.utils.MovieDomainConstants

object CinemaQueries {
    fun applyPopularMovie():HashMap<String,String>{
        val query:HashMap<String,String> =HashMap()
        query[MovieDomainConstants.QUERY_API_KEY]= MovieDomainConstants.API_KEY
        query["page"]="1"
        query[MovieDomainConstants.SORTBY_KEY]="popularity.desc"
        return query
    }

    fun applyPopularSeries():HashMap<String,String>{
        val query:HashMap<String,String> =HashMap()
        query[MovieDomainConstants.QUERY_API_KEY]= MovieDomainConstants.API_KEY
        query["page"]="2"
        query[MovieDomainConstants.SORTBY_KEY]="popularity.desc"
        return query
    }

    fun applyPopularActors():HashMap<String,String>{
        val query:HashMap<String,String> =HashMap()
        query[MovieDomainConstants.QUERY_API_KEY]= MovieDomainConstants.API_KEY
        query["page"]="1"
        return query
    }
    fun applyApiKey():HashMap<String,String>{
        val query:HashMap<String,String> =HashMap()
        query[MovieDomainConstants.QUERY_API_KEY]= MovieDomainConstants.API_KEY
        return query
    }
    fun applyQueri(page:String):HashMap<String,String> {
        val map=HashMap<String,String>()
        map[MovieDomainConstants.QUERY_API_KEY]= MovieDomainConstants.API_KEY
        map["page"]=page
        return map
    }
    fun applySearchQueri(queryy:String, page:String):HashMap<String,String> {
        val query:HashMap<String,String> =HashMap()
        query[MovieDomainConstants.QUERY_API_KEY]= MovieDomainConstants.API_KEY
        query["query"]=queryy
        query["page"]=page
        return query
    }
}