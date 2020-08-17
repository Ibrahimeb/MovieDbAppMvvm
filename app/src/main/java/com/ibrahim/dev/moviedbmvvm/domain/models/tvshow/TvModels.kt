package com.ibrahim.dev.moviedbmvvm.domain.models.tvshow

import androidx.room.PrimaryKey
import com.ibrahim.dev.moviedbmvvm.domain.models.movie.MovieItemListModels

data class TvModels(
    @PrimaryKey
    val page: Int,
    val totalPage: Int,
    val tvListItemListModels: List<TvListItemModels>
)