package com.ibrahim.dev.moviedbmvvm.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view) {

   abstract fun bind(callback:() -> Unit,dataItem: DataItem)

}