package com.ibrahim.dev.moviedbmvvm.data.repository

import com.ibrahim.dev.moviedbmvvm.app.di.ApiKey
import com.ibrahim.dev.moviedbmvvm.data.network.MovieApi
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.flow
import retrofit2.http.Query
import javax.inject.Inject

@ActivityScoped
class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    @ApiKey private val apiKey: String
) {
    fun getPopularMovie(
        @Query("language") language: String = "en-US"
    ) = flow {
        emit(movieApi.getMoviePopular(apiKey, language).toModel())
    }

    fun getMovieUpComing(){}

    fun getMovieTopRated(){}

    fun getMovieCategory(){}
}