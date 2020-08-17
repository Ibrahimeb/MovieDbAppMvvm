package com.ibrahim.dev.moviedbmvvm.presentation.adapter

import com.ibrahim.dev.moviedbmvvm.domain.models.movie.MovieItemListModels
import com.ibrahim.dev.moviedbmvvm.domain.models.tvshow.TvListItemModels

sealed class DataItem {

    class MovieItem(val movieItem: MovieItemListModels) : DataItem() {
        override val id = movieItem.id.toLong()
    }

    class TvShowItem(val tvShowItem: TvListItemModels) : DataItem() {
        override val id = tvShowItem.id.toLong()
    }

    class MovieItemHome(val movieItem: MovieItemListModels) : DataItem() {
        override val id = movieItem.id.toLong()
    }

    class TvShowItemHome(val tvShowItem: TvListItemModels) : DataItem() {
        override val id = tvShowItem.id.toLong()
    }

    class SubListHomeItemMovie(val list: List<MovieItemListModels>) : DataItem() {
        override val id = list.size.toLong()
    }

    class SubListHomeItemTvShow(val list: List<TvListItemModels>) : DataItem() {
        override val id = list.size.toLong()
    }

    class ItemHeader(val text: String) : DataItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}