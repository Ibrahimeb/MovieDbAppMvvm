package com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ibrahim.dev.moviedbmvvm.R
import com.ibrahim.dev.moviedbmvvm.app.utils.Utils
import com.ibrahim.dev.moviedbmvvm.databinding.ItemHomeBinding
import com.ibrahim.dev.moviedbmvvm.databinding.ItemListBinding
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.DataItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.ItemViewHolder
import com.squareup.picasso.Picasso

class MovieAndTvShowHomeViewHolder(private val binding: ItemHomeBinding) :
    ItemViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): MovieAndTvShowHomeViewHolder =
            MovieAndTvShowHomeViewHolder(
                ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun bind(callback: () -> Unit, dataItem: DataItem) {
        when (dataItem) {
            is DataItem.TvShowItem -> bindTvShow(dataItem)
            is DataItem.MovieItem -> bindMovie(dataItem)
        }
    }

    private fun bindMovie(dataItem: DataItem.MovieItem) {
        binding.apply {
            with(dataItem.movieItem) {
                textViewTitle.text = originalTitle
                Picasso.get().load(Utils.getImageUrlLarge(posterPath))
                    .placeholder(R.drawable.placeholder_movie).fit().into(imageViewItemHome)

            }
        }
    }

    private fun bindTvShow(dataItem: DataItem.TvShowItem) {
        binding.apply {
            with(dataItem.tvShowItem) {
                textViewTitle.text = originalName
                Picasso.get()
                    .load(Utils.getImageUrlLarge(posterPath))
                    .placeholder(R.drawable.placeholder_movie).fit()
                    .into(imageViewItemHome)

            }
        }
    }

}