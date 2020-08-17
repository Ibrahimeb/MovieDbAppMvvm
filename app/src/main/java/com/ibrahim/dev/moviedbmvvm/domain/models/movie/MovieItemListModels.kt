package com.ibrahim.dev.moviedbmvvm.domain.models.movie

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResponseMovie

@Entity(
    foreignKeys = [ForeignKey(
        entity = ResponseMovie::class,
        childColumns = arrayOf("originPage"),
        parentColumns = arrayOf("page"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class MovieItemListModels(
    val overview: String,
    val originalTitle: String,
    val originalLanguage: String,
    val genreIds: List<Int>,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    @PrimaryKey
    val id: Int,
    val originPage:Int
    )