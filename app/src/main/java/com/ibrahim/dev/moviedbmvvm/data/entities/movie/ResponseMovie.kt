package com.ibrahim.dev.moviedbmvvm.data.entities.movie

import com.google.gson.annotations.SerializedName
import com.ibrahim.dev.moviedbmvvm.domain.models.movie.MovieModels
import com.ibrahim.dev.moviedbmvvm.domain.models.movie.MovieItemListModels

data class ResponseMovie(

    @field:SerializedName("page")
    private val page: Int = -1,

    @field:SerializedName("total_pages")
    private val totalPage: Int,

    @field:SerializedName("results")
    private val results: List<ResultsItem> = emptyList()
) {
    fun toModel() = MovieModels(page, totalPage, results.map {
        with(it) {
            MovieItemListModels(
                overview,
                originalTitle,
                originalLanguage,
                genreIds,
                posterPath,
                backdropPath.orEmpty(),
                releaseDate,
                voteAverage,
                id,
                page
            )
        }
    })
}