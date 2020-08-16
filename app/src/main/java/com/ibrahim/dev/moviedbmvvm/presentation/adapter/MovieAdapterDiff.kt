package com.ibrahim.dev.moviedbmvvm.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResultsItem

class MovieAdapterDiff : DiffUtil.ItemCallback<ResultsItem>() {

    override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
        return oldItem == newItem
    }
}