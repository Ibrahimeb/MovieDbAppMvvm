package com.ibrahim.dev.moviedbmvvm.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.actions.EventGenericAdapter

abstract class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view) {

   abstract fun bind(callback:(EventGenericAdapter) -> Unit,dataItem: DataItem)

}