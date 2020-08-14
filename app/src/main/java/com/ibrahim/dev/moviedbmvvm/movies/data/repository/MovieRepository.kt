package com.ibrahim.dev.moviedbmvvm.movies.data.repository

import com.ibrahim.dev.moviedbmvvm.app.di.ApiKey
import com.ibrahim.dev.moviedbmvvm.movies.data.entities.ResponseMovie
import com.ibrahim.dev.moviedbmvvm.movies.data.network.MovieApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import retrofit2.http.Query
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    @ApiKey private val apiKey: String
) {
    fun getPopularMovie(
        @Query("language") language: String = "en-US"
    ) = flow {
        emit(movieApi.getMoviePopular(apiKey, language))
    }
}