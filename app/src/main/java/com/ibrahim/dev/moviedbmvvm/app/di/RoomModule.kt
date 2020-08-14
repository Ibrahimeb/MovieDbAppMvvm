package com.ibrahim.dev.moviedbmvvm.app.di

import android.app.Application
import androidx.room.Room
import com.ibrahim.dev.moviedbmvvm.app.data.MovieDbLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
class RoomModule {


    @Provides
    fun providesRoomDatabase(application: Application): MovieDbLocal? {
        return Room.databaseBuilder(application, MovieDbLocal::class.java, "movie-db")
            .build()
    }
}