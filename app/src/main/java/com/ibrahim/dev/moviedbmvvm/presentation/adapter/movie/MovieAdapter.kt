package com.ibrahim.dev.moviedbmvvm.presentation.adapter.movie

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResultsItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.MovieAdapterDiff

class MovieAdapter(private val context: Context) : ListAdapter<ResultsItem, MovieViewHolder>(
    MovieAdapterDiff()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(
            parent,
            context
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindViewHolder(getItem(position))
    }
}