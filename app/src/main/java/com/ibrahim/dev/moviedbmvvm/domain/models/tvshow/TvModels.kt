package com.ibrahim.dev.moviedbmvvm.domain.models.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity
data class TvModels(
    @PrimaryKey
    val page: Int,
    val totalPage: Int,
    val tvListItemListModels: List<TvListItemModels>,
    val timestamp: Timestamp = Timestamp(System.currentTimeMillis())

)