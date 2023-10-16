package com.guilhermereisdev.tvguide.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.guilhermereisdev.tvguide.R
import com.guilhermereisdev.tvguide.databinding.ActivityHomeBinding
import com.guilhermereisdev.tvguide.presentation.artist.ArtistActivity
import com.guilhermereisdev.tvguide.presentation.movie.MovieActivity
import com.guilhermereisdev.tvguide.presentation.tvshow.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.moviesButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }
        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}
