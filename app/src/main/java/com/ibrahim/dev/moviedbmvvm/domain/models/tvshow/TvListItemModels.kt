package com.ibrahim.dev.moviedbmvvm.domain.models.tvshow

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = TvModels::class,
        childColumns = arrayOf("originPage"),
        parentColumns = arrayOf("page"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class TvListItemModels(
    val overview: String,
    val originalName: String,
    val originalLanguage: String,
    val genreIds: List<Int>,
    val posterPath: String,
    val backdropPath: String,
    val originCountry: List<String>,
    val firstAirDate: String,
    val popularity: Double,
    @PrimaryKey
    val id: Int,
    val originPage:Int
)