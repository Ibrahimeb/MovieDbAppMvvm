package com.ibrahim.dev.moviedbmvvm.app.data.commos

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResponseMovie

interface MovieDao {

    @Update
    fun update(responseMovie: ResponseMovie)

    @Insert
    fun insert(responseMovie: ResponseMovie)

    @Query("SELECT * FROM ResponseMovie WHERE page=:page")
    fun getResponseMovieByPage(page:Int)

}