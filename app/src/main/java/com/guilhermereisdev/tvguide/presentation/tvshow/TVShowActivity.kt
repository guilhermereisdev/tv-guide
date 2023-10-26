package com.guilhermereisdev.tvguide.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.guilhermereisdev.tvguide.R
import com.guilhermereisdev.tvguide.databinding.ActivityTvshowBinding
import com.guilhermereisdev.tvguide.presentation.di.Injector
import javax.inject.Inject

class TVShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TVShowViewModelFactory
    private lateinit var tvShowViewModel: TVShowViewModel
    private lateinit var binding: ActivityTvshowBinding
    private lateinit var adapter: TVShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshow)
        setSupportActionBar(binding.toolbar)
        (application as Injector).createTVShowSubcomponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TVShowViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.apply {
            tvShowRecyclerView.layoutManager = LinearLayoutManager(this@TVShowActivity)
            adapter = TVShowAdapter()
            binding.tvShowRecyclerView.adapter = adapter
        }
        displayPopularTVShows()
    }

    private fun displayPopularTVShows() {
        binding.apply {
            tvShowProgressBar.visibility = View.VISIBLE
        }

        val responseLiveData = tvShowViewModel.getTVShows()
        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.apply {
                    tvShowProgressBar.visibility = View.GONE
                }
            } else {
                binding.apply {
                    tvShowProgressBar.visibility = View.GONE
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
                updateTVShows()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTVShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTVShows()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else
                binding.tvShowProgressBar.visibility = View.GONE
        }
    }
}
