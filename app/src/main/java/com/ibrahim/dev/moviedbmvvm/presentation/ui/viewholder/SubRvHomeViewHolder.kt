package com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.dev.moviedbmvvm.databinding.ItemSubRvHomeBinding
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.DataItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.GenericAdapter
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.ItemViewHolder
import java.lang.Exception

class SubRvHomeViewHolder(private val binding: ItemSubRvHomeBinding) :
    ItemViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): SubRvHomeViewHolder =
            SubRvHomeViewHolder(
                ItemSubRvHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun bind(callback: () -> Unit, dataItem: DataItem) {
        val genericAdapter = GenericAdapter {}
        binding.recyclerview.apply {
            adapter = genericAdapter
            layoutManager =
                LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        }

        genericAdapter.addHeaderAndSubmitList(
            when (dataItem) {
                is DataItem.SubListHomeItemMovie -> getSorterListMovie(dataItem)
                is DataItem.SubListHomeItemTvShow -> getSorterListTvShow(dataItem)
                else -> throw Exception("wrong type list in ${this::class.java.simpleName}")
            }
        )
    }


    private fun getSorterListTvShow(dataItem: DataItem.SubListHomeItemTvShow): List<DataItem> {
        return dataItem.list.map { DataItem.TvShowItem(it) }
    }

    private fun getSorterListMovie(dataItem: DataItem.SubListHomeItemMovie): List<DataItem> {
        return dataItem.list.map { DataItem.MovieItem(it) }
    }

}