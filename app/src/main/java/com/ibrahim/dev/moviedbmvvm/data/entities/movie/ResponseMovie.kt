package com.ibrahim.dev.moviedbmvvm.data.entities.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ResponseMovie(

    @PrimaryKey
    @field:SerializedName("page")
    val page: Int = -1,

    @field:SerializedName("total_pages")
    val totalPage: Int,

    @field:SerializedName("results")
    val results: List<ResultsItem> = emptyList()
)