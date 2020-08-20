package com.ibrahim.dev.moviedbmvvm.domain.models.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity
data class MovieModels(
    @PrimaryKey
    val page: Int,
    val totalPage: Int,
    val pageMovieModels: List<MovieItemListModels>,
    val timestamp: Timestamp = Timestamp(System.currentTimeMillis())
)