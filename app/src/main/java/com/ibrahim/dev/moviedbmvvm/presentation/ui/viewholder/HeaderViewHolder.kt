package com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ibrahim.dev.moviedbmvvm.databinding.ItemHeaderHomeBinding
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.DataItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.ItemViewHolder

class HeaderViewHolder(private val binding: ItemHeaderHomeBinding) : ItemViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): HeaderViewHolder =
            HeaderViewHolder(
                ItemHeaderHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun bind(callback: () -> Unit, dataItem: DataItem) {
        val item = dataItem as DataItem.ItemHeader
        binding.textViewHeaderHome.text = item.text

    }
}