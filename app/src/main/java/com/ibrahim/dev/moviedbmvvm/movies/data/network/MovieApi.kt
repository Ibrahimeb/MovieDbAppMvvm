package com.ibrahim.dev.moviedbmvvm.movies.data.network

import com.ibrahim.dev.moviedbmvvm.movies.data.entities.ResponseMovie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getMoviePopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ResponseMovie

    @GET("movie/upcoming")
    suspend fun getMovieUpComing(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ResponseMovie

    @GET("movie/top_rated")
    suspend fun getMovietopRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ResponseMovie

    @GET("genre/movie/list")
    suspend fun getMovieCategory(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ResponseMovie

}