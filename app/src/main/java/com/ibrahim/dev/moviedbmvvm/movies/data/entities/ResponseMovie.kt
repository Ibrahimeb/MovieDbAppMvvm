package com.ibrahim.dev.moviedbmvvm.movies.data.entities

import com.google.gson.annotations.SerializedName

data class ResponseMovie(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("results")
    val results: List<ResultsItem?>? = null
)