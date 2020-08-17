package com.ibrahim.dev.moviedbmvvm.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder.HeaderViewHolder
import com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder.MovieAndTvShowHomeViewHolder
import com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder.MovieAndTvShowViewHolder
import com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder.SubRvHomeViewHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GenericAdapter(private val callback: () -> Unit) :
    ListAdapter<DataItem, ItemViewHolder>(AdapterDiff()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (viewType) {
            VIEW_MOVIE, VIEW_TV -> MovieAndTvShowViewHolder.from(parent)
            VIEW_MOVIE_HOME, VIEW_TV_HOME -> MovieAndTvShowHomeViewHolder.from(parent)
            VIEW_HEADER -> HeaderViewHolder.from(parent)
            VIEW_LIST_HOME -> SubRvHomeViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(callback, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.ItemHeader -> VIEW_HEADER
            is DataItem.MovieItem -> VIEW_MOVIE
            is DataItem.TvShowItem -> VIEW_TV
            is DataItem.MovieItemHome -> VIEW_MOVIE_HOME
            is DataItem.TvShowItemHome -> VIEW_TV_HOME
            is DataItem.SubListHomeItemMovie -> VIEW_LIST_HOME
            is DataItem.SubListHomeItemTvShow -> VIEW_LIST_HOME
            else -> NO_VIEW_FOUND
        }
    }

    fun addHeaderAndSubmitList(list: List<DataItem>) {
        adapterScope.launch {
            withContext(Dispatchers.Main) {
                submitList(list)
            }
        }
    }

    companion object {
        const val VIEW_HEADER = 0
        const val VIEW_MOVIE = 1
        const val VIEW_TV = 2
        const val VIEW_LIST_HOME = 3
        const val VIEW_MOVIE_HOME = 4
        const val VIEW_TV_HOME = 5
        const val NO_VIEW_FOUND = -1
    }
}