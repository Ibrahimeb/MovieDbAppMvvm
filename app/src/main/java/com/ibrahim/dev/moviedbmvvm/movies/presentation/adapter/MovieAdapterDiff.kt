package com.ibrahim.dev.moviedbmvvm.movies.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ibrahim.dev.moviedbmvvm.movies.data.entities.ResultsItem

class MovieAdapterDiff : DiffUtil.ItemCallback<ResultsItem>() {

    override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
        return oldItem == newItem
    }
}