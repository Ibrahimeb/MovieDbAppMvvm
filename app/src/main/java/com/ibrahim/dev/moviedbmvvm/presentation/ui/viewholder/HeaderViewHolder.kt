package com.ibrahim.dev.moviedbmvvm.presentation.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ibrahim.dev.moviedbmvvm.databinding.ItemHeaderHomeBinding
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.DataItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.ItemViewHolder
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.actions.EventGenericAdapter

class HeaderViewHolder(private val binding: ItemHeaderHomeBinding) : ItemViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): HeaderViewHolder =
            HeaderViewHolder(
                ItemHeaderHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun bind(callback: (EventGenericAdapter) -> Unit, dataItem: DataItem) {
        val item = dataItem as DataItem.ItemHeader
        binding.textViewHeaderHome.text = item.text

        binding.root.setOnClickListener {
            callback.invoke(EventGenericAdapter.LaunchSpecificListFragment(dataItem.text))
        }

    }
}