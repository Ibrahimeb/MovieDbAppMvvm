package com.ibrahim.dev.moviedbmvvm.presentation.adapter.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.dev.moviedbmvvm.R
import com.ibrahim.dev.moviedbmvvm.app.utils.Utils
import com.ibrahim.dev.moviedbmvvm.databinding.ItemMovieBinding
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResultsItem
import com.squareup.picasso.Picasso

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup, context: Context): MovieViewHolder =
            MovieViewHolder(
                ItemMovieBinding.inflate(LayoutInflater.from(context), parent, false)
            )
    }

    fun bindViewHolder(item: ResultsItem) {

        binding.apply {
            tvTitle.text = item.title
            tvRate.text = item.voteAverage.toString()
            tvYear.text = Utils.getYear(Utils.parseStringDate(item.releaseDate)).toString()

            Picasso.get().load(Utils.getImageUrlLarge(item.posterPath))
                .placeholder(R.drawable.placeholder_movie).fit().into(ivItemMovie)

        }

    }

}