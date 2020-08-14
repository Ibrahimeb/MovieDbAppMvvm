package com.ibrahim.dev.moviedbmvvm.movies.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ibrahim.dev.moviedbmvvm.movies.data.entities.ResultsItem

class MovieAdapter(private val context: Context) : ListAdapter<ResultsItem,MovieViewHolder>(MovieAdapterDiff()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent,context)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindViewHolder(getItem(position))
    }
}