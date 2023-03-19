package com.example.domin.usecases.persisitence

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domin.models.GenreSeries
import com.example.domin.models.Series
import com.example.domin.repo.MoviesRepositry
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.*

@OptIn(ExperimentalCoroutinesApi::class)
class IsFavSeriesUseCaseTest {


    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()


    private lateinit var useCases: IsFavSeriesUseCase
    private lateinit var repositry: MoviesRepositry

    @Before
    fun setUp() {
        repositry= mock<MoviesRepositry>()
        useCases= IsFavSeriesUseCase(repositry)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun `verify if repository call getFavSeries fun`()= runTest{
        val favoriteSeries = listOf(
            dummySeries,
            dummySeries
        )
        whenever(repositry.getFavSeries()).thenReturn(flowOf(favoriteSeries))
        useCases(1).collect{}
        verify(repositry).getFavSeries()


    }

    @Test
    fun `should emit true if series is favorite`(): Unit = runTest {
        val favoriteSeries = listOf(
            dummySeries,
            dummySeries
        )

        whenever(repositry.getFavSeries()).thenReturn(flowOf(favoriteSeries))
        val result = useCases(3).first()
        assertFalse(result)
        verify(repositry, times(1)).getFavSeries()
    }

    @Test
    fun `should emit false if series is not favorite`(): Unit = runTest {
        val favoriteSeries = listOf(
            dummySeries,
            dummySeries
        )

        whenever(repositry.getFavSeries()).thenReturn(flowOf(favoriteSeries))
        val result = useCases(123).first()
        assertTrue(result)
        verify(repositry, times(1)).getFavSeries()
    }
}


val dummySeries = Series(
    backdropPath = "",
    createdBy = emptyList(),
    episodeRunTime = listOf(30, 60),
    firstAirDate = "",
    genres = listOf(
        GenreSeries(id = 1, name = "Comedy"),
        GenreSeries(id = 2, name = "Drama")
    ),
    homepage = "https://www.example.com",
    id = 123,
    inProduction = true,
    languages = listOf("en", "es"),
    lastAirDate = "",
    lastEpisodeToAir = "",
    name = "Dummy Series",
    networks = emptyList(),
    nextEpisodeToAir = "",
    numberOfEpisodes = 10,
    numberOfSeasons = 2,
    originCountry = listOf("US"),
    originalLanguage = "en",
    originalName = "Dummy Series",
    overview = "Lorem ipsum dolor sit amet.",
    popularity = 7.5,
    posterPath = "",
    productionCompanies = emptyList(),
    productionCountries = emptyList(),
    seasons = emptyList(),
    status = "Returning Series",
    tagline = "Lorem ipsum dolor sit amet.",
    type = "Scripted",
    voteAverage = 8.0,
    voteCount = 100
)