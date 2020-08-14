package com.ibrahim.dev.moviedbmvvm.movies.data.repository

import com.ibrahim.dev.moviedbmvvm.movies.data.entities.ResponseMovie
import com.ibrahim.dev.moviedbmvvm.movies.data.network.MovieApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import retrofit2.http.Query
import javax.inject.Inject

class MovieRepository @Inject constructor(val movieApi: MovieApi) {

    fun getPopularMovie(
        @Query("api_key") apiKey: String = "",
        @Query("language") language: String = "en"
    ) = flow {
        emit(movieApi.getMoviePopular(apiKey,language))
    }.catch {

    }


}