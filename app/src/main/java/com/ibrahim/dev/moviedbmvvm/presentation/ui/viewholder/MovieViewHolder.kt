package com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ibrahim.dev.moviedbmvvm.R
import com.ibrahim.dev.moviedbmvvm.app.utils.Utils
import com.ibrahim.dev.moviedbmvvm.databinding.ItemListBinding
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.DataItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.ItemViewHolder
import com.squareup.picasso.Picasso

class MovieViewHolder(private val binding: ItemListBinding) : ItemViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): MovieViewHolder =
            MovieViewHolder(
                ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }


    override fun bind(callback: () -> Unit, dataItem: DataItem) {
        val item = dataItem as DataItem.MovieItem
        binding.apply {
            with(item.movieItem) {
                tvTitle.text = originalTitle
                tvRate.text = voteAverage.toString()
                tvYear.text = Utils.getYear(Utils.parseStringDate(releaseDate)).toString()
                Picasso.get().load(Utils.getImageUrlLarge(posterPath))
                    .placeholder(R.drawable.placeholder_movie).fit().into(ivItemMovie)

            }
        }
    }

}