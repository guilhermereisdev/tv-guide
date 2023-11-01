package com.guilhermereisdev.tvguide.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.guilhermereisdev.tvguide.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMovieTest() = runBlocking {
        val movies = listOf(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 1, originalLanguage = null, originalTitle = null, overview = "overview1", popularity = null, posterPath = "posterPath1", releaseDate = "releaseDate1", title = "title1", video = null, voteAverage = null, voteCount = null),
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 2, originalLanguage = null, originalTitle = null, overview = "overview2", popularity = null, posterPath = "posterPath2", releaseDate = "releaseDate2", title = "title2", video = null, voteAverage = null, voteCount = null),
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 3, originalLanguage = null, originalTitle = null, overview = "overview3", popularity = null, posterPath = "posterPath3", releaseDate = "releaseDate3", title = "title3", video = null, voteAverage = null, voteCount = null),
        )
        dao.saveMovies(movies)

        val allMovies = dao.getMovies()
        assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 1, originalLanguage = null, originalTitle = null, overview = "overview1", popularity = null, posterPath = "posterPath1", releaseDate = "releaseDate1", title = "title1", video = null, voteAverage = null, voteCount = null),
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 2, originalLanguage = null, originalTitle = null, overview = "overview2", popularity = null, posterPath = "posterPath2", releaseDate = "releaseDate2", title = "title2", video = null, voteAverage = null, voteCount = null),
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 3, originalLanguage = null, originalTitle = null, overview = "overview3", popularity = null, posterPath = "posterPath3", releaseDate = "releaseDate3", title = "title3", video = null, voteAverage = null, voteCount = null),
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()

        val moviesResult = dao.getMovies()
        assertThat(moviesResult).isEmpty()
    }
}
