package com.example.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data.local.localdto.MovieLocal
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    private lateinit var movieDatabase:MovieDataBase
    private lateinit var movieDao:MovieDao


    @get:Rule
    val instantExecutorRule=InstantTaskExecutorRule()

    @Before
    fun before(){
        movieDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MovieDataBase::class.java).build()

        movieDao = movieDatabase.myDao()
    }

    @After
    fun after() {
        movieDatabase.close()
    }



    @Test
    fun save_favorite_correct()= runBlockingTest {
        val favMovie=MovieLocal()
        movieDao.insertFavMovie(favMovie)

        assertThat(movieDao.getFavMovies().first().size).isEqualTo(1)
        assertThat(movieDao.getFavMovies().first()[0]).isEqualTo(favMovie)
    }


    @Test
    fun delete_favorite_correct()= runBlockingTest {
        val favMovie=MovieLocal()
        movieDao.insertFavMovie(favMovie)
        movieDao.deleteFavMovie(favMovie)

        assertThat(movieDao.getFavMovies().first().size).isEqualTo(0)

    }


}