package com.guilhermereisdev.tvguide.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.guilhermereisdev.tvguide.R
import com.guilhermereisdev.tvguide.databinding.ActivityMovieBinding
import com.guilhermereisdev.tvguide.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubcomponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory)
            .get(MovieViewModel::class.java)

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            Log.i("MYTAG", it.toString())
        }
    }
}
