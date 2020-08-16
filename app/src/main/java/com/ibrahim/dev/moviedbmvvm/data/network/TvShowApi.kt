package com.ibrahim.dev.moviedbmvvm.data.network

import com.ibrahim.dev.moviedbmvvm.data.entities.ResponseCategory
import com.ibrahim.dev.moviedbmvvm.data.entities.tvshow.ResponseTvShow
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowApi {

    @GET("tv/popular")
    suspend fun getTvPopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ResponseTvShow

    @GET("tv/on_the_air")
    suspend fun getTvOnAir(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ResponseTvShow

    @GET("tv/top_rated")
    suspend fun getTvtopRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ResponseTvShow

    @GET("genre/tv/list")
    suspend fun getTvShowCategory(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): ResponseCategory

}