package com.ibrahim.dev.moviedbmvvm.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahim.dev.moviedbmvvm.app.data.commos.MovieDao
import com.ibrahim.dev.moviedbmvvm.app.data.commos.TvShowDao
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResponseMovie

@Database(entities = [ResponseMovie::class], version = 1)
abstract class MovieDbLocal : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao

}