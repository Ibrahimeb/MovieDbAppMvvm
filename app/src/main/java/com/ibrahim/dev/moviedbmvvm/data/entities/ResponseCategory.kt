package com.ibrahim.dev.moviedbmvvm.data.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class ResponseCategory(

    @field:SerializedName("genres")
    val genres: List<GenresItem>
)

data class GenresItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int
)
