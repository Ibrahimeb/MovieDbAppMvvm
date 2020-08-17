package com.ibrahim.dev.moviedbmvvm.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResultsItem

class AdapterDiff : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
      return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }


}