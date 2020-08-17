package com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ibrahim.dev.moviedbmvvm.R
import com.ibrahim.dev.moviedbmvvm.app.utils.Utils
import com.ibrahim.dev.moviedbmvvm.databinding.ItemListBinding
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.DataItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.ItemViewHolder
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.actions.EventGenericAdapter
import com.squareup.picasso.Picasso

class MovieAndTvShowViewHolder(private val binding: ItemListBinding) :
    ItemViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): MovieAndTvShowViewHolder =
            MovieAndTvShowViewHolder(
                ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun bind(callback: (EventGenericAdapter) -> Unit, dataItem: DataItem) {
        when (dataItem) {
            is DataItem.TvShowItem -> bindTvShow(dataItem)
            is DataItem.MovieItem -> bindMovie(dataItem)
        }
    }

    private fun bindMovie(dataItem: DataItem.MovieItem) {
        binding.apply {
            with(dataItem.movieItem) {
                tvTitle.text = originalTitle
                tvRate.text = voteAverage.toString()
                tvYear.text = Utils.getYear(Utils.parseStringDate(releaseDate)).toString()
                Picasso.get().load(Utils.getImageUrlLarge(posterPath))
                    .placeholder(R.drawable.placeholder_movie).fit().into(ivItemMovie)

            }
        }
    }

    private fun bindTvShow(dataItem: DataItem.TvShowItem) {
        binding.apply {
            with(dataItem.tvShowItem) {
                tvTitle.text = originalName
                tvRate.text = voteAverage.toString()
                tvYear.text = Utils.getYear(
                    Utils.parseStringDate(firstAirDate)
                ).toString()
                Picasso.get()
                    .load(Utils.getImageUrlLarge(posterPath))
                    .placeholder(R.drawable.placeholder_movie).fit()
                    .into(ivItemMovie)

            }
        }
    }

}