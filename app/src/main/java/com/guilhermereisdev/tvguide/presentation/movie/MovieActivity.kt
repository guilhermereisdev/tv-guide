package com.guilhermereisdev.tvguide.presentation.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.guilhermereisdev.tvguide.R
import com.guilhermereisdev.tvguide.databinding.ActivityMovieBinding
import com.guilhermereisdev.tvguide.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        setSupportActionBar(binding.toolbar)
        (application as Injector).createMovieSubcomponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory)
            .get(MovieViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.apply {
            movieRecyclerView.layoutManager = LinearLayoutManager(this@MovieActivity)
            adapter = MovieAdapter()
            binding.movieRecyclerView.adapter = adapter
        }
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.apply {
            movieProgressBar.visibility = View.VISIBLE
        }

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.apply {
                    movieProgressBar.visibility = View.GONE
                }
            } else {
                binding.apply {
                    movieProgressBar.visibility = View.GONE
                }
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else
                binding.movieProgressBar.visibility = View.GONE
        }
    }

}
