package com.ibrahim.dev.moviedbmvvm.domain.models

import androidx.room.Entity

@Entity
data class CategoryModel(
    val itemList: List<GenresItemModel>
)

@Entity
data class GenresItemModel(
    val name: String,
    val id: Int
)