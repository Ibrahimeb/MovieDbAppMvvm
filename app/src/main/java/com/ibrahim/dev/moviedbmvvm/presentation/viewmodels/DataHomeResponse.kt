package com.ibrahim.dev.moviedbmvvm.presentation.viewmodels

import com.ibrahim.dev.moviedbmvvm.domain.models.movie.MovieModels
import com.ibrahim.dev.moviedbmvvm.domain.models.tvshow.TvModels

sealed class DataHomeResponse {

    class MovieResponse(val movieResponse: MovieModels, val headerText: String) : DataHomeResponse()

    class TvShowResponse(val tvShowResponse: TvModels, val headerText: String) : DataHomeResponse()



}
