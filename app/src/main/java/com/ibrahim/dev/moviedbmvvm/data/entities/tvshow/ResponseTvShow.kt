package com.ibrahim.dev.moviedbmvvm.data.entities.tvshow

import com.google.gson.annotations.SerializedName
import com.ibrahim.dev.moviedbmvvm.domain.models.tvshow.TvListItemModels
import com.ibrahim.dev.moviedbmvvm.domain.models.tvshow.TvModels
import com.ibrahim.moviedbapp.home.tvShow.models.ResultsItemTv

data class ResponseTvShow(

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")
    val results: List<ResultsItemTv>,

    @field:SerializedName("total_results")
    val totalResults: Int
) {
    fun toModel() = TvModels(page, totalPages, results.map {
        with(it) {
            TvListItemModels(
                overview,
                originalName,
                originalLanguage,
                genreIds,
                posterPath,
                backdropPath.orEmpty(),
                originCountry,
                firstAirDate,
                voteAverage,
                id,
                page
            )
        }
    })
}

