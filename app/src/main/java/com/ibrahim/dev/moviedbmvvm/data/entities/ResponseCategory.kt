package com.ibrahim.dev.moviedbmvvm.data.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.ibrahim.dev.moviedbmvvm.domain.models.CategoryModel
import com.ibrahim.dev.moviedbmvvm.domain.models.GenresItemModel

@Entity
data class ResponseCategory(

    @field:SerializedName("genres")
    private val genres: List<GenresItem>
) {
    fun toModel() = CategoryModel(
        genres.map {
            with(it) {
                GenresItemModel(name, id)
            }
        })
}

data class GenresItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int
)
