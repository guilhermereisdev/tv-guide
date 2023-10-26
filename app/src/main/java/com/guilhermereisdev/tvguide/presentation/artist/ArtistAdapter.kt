package com.guilhermereisdev.tvguide.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guilhermereisdev.tvguide.R
import com.guilhermereisdev.tvguide.data.model.artist.Artist
import com.guilhermereisdev.tvguide.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = artistList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }
}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.apply {
            titleTextView.text = artist.name
            descriptionTextView.text = artist.popularity.toString()
            val posterURL = "https://image.tmdb.org/t/p/w500/${artist.profilePath}"
            Glide.with(imageView.context)
                .load(posterURL)
                .into(imageView)
        }
    }
}
