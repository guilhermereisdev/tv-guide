package com.guilhermereisdev.tvguide.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.guilhermereisdev.tvguide.data.model.movie.Movie
import com.guilhermereisdev.tvguide.data.repository.movie.FakeMovieRepository
import com.guilhermereisdev.tvguide.domain.usecase.GetMoviesUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateMoviesUseCase
import com.guilhermereisdev.tvguide.getOrAwaitValue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(manifest=Config.NONE)
@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.add(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 1, originalLanguage = null, originalTitle = null, overview = "overview1", popularity = null, posterPath = "posterPath1", releaseDate = "releaseDate1", title = "title1", video = null, voteAverage = null, voteCount = null)
        )
        movies.add(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 2, originalLanguage = null, originalTitle = null, overview = "overview2", popularity = null, posterPath = "posterPath2", releaseDate = "releaseDate2", title = "title2", video = null, voteAverage = null, voteCount = null)
        )

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.add(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 3, originalLanguage = null, originalTitle = null, overview = "overview3", popularity = null, posterPath = "posterPath3", releaseDate = "releaseDate3", title = "title3", video = null, voteAverage = null, voteCount = null)
        )
        movies.add(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 4, originalLanguage = null, originalTitle = null, overview = "overview4", popularity = null, posterPath = "posterPath4", releaseDate = "releaseDate4", title = "title4", video = null, voteAverage = null, voteCount = null)
        )

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}