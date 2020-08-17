package com.ibrahim.dev.moviedbmvvm.data.repository

import com.ibrahim.dev.moviedbmvvm.app.di.ApiKey
import com.ibrahim.dev.moviedbmvvm.data.network.MovieApi
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ActivityScoped
class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    @ApiKey private val apiKey: String
) {

    fun getPopularMovie() = flow {
        emit(movieApi.getMoviePopular(apiKey).toModel())
    }

    fun getMovieUpComing() = flow {
        emit(movieApi.getMovieUpComing(apiKey).toModel())
    }

    fun getMovieTopRated() = flow {
        emit(movieApi.getMovietopRated(apiKey).toModel())
    }

    fun getMovieCategory() = flow {
        emit(movieApi.getMovieCategory(apiKey).toModel())
    }
}