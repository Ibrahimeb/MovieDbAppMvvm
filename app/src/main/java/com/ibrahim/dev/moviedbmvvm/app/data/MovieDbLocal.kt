package com.ibrahim.dev.moviedbmvvm.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahim.dev.moviedbmvvm.movies.data.entities.ResponseMovie

@Database(entities = [ResponseMovie::class], version = 1)
abstract class MovieDbLocal : RoomDatabase() {

}