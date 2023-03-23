package com.example.data.remote

import com.example.domin.utils.MovieDomainConstants
import com.google.common.io.Resources.getResource
import com.google.common.truth.Truth.assertThat
import com.google.gson.JsonParser
import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
@OptIn(ExperimentalCoroutinesApi::class)
class RemoteMovieApiTest {

    @get:Rule
    private lateinit var mockWebServer : MockWebServer

    private lateinit var retrofit:Retrofit

    private lateinit var remoteMovieApi :RemoteMovieApi

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        remoteMovieApi = retrofit.create(RemoteMovieApi::class.java)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    private val testPopularMovieJson=getResource("getPopularMovieSuccessResponse.json")?.readText()


    @Test
    fun get_Popular_Movie_Emit_Sucess_Response()= runTest{
        mockWebServer.enqueue(
            MockResponse()
                .setBody(testPopularMovieJson!!)
                .setResponseCode(200)
        )


        val query:HashMap<String,String> =HashMap()
        query[MovieDomainConstants.QUERY_API_KEY]= MovieDomainConstants.API_KEY
        query["page"]="1"
        query[MovieDomainConstants.SORTBY_KEY]="popularity.desc"

        val testObserver = remoteMovieApi.getPopulateMovie(query)
        assertThat(testObserver.code()).isEqualTo(200)
        assertThat(testObserver.body()).isNotNull()
    }
}