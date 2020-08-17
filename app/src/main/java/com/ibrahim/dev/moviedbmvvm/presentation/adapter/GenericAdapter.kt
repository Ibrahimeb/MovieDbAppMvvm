package com.ibrahim.dev.moviedbmvvm.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder.MovieViewHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GenericAdapter(private val callback: () -> Unit) :
    ListAdapter<DataItem, ItemViewHolder>(AdapterDiff()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (viewType) {
            VIEW_MOVIE -> MovieViewHolder.from(parent)

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
    }
}