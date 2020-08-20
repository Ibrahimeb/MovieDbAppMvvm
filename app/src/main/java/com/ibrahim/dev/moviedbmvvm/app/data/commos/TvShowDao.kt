package com.ibrahim.dev.moviedbmvvm.app.data.commos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResponseMovie

interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(responseMovie: ResponseMovie)

    @Query("SELECT * FROM TvModels WHERE page=:page")
    fun getResponseMovieByPage(page:Int)

}