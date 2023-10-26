package com.guilhermereisdev.tvguide.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guilhermereisdev.tvguide.R
import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow
import com.guilhermereisdev.tvguide.databinding.ListItemBinding

class TVShowAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TVShow>()

    fun setList(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
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

    override fun getItemCount(): Int = tvShowList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }
}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TVShow) {
        binding.apply {
            titleTextView.text = tvShow.name
            descriptionTextView.text = tvShow.overview
            val posterURL = "https://image.tmdb.org/t/p/w500/${tvShow.posterPath}"
            Glide.with(imageView.context)
                .load(posterURL)
                .into(imageView)
        }
    }
}
