package com.ibrahim.dev.moviedbmvvm.di

import com.ibrahim.dev.moviedbmvvm.app.data.MovieDbLocal
import com.ibrahim.dev.moviedbmvvm.app.data.commos.MovieDao
import com.ibrahim.dev.moviedbmvvm.app.data.commos.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class DaoModule {

    @Provides
    fun providerDaoMovie(db: MovieDbLocal): MovieDao {
        return db.movieDao()
    }

    @Provides
    fun providerDaoTv(db: MovieDbLocal): TvShowDao {
        return db.tvShowDao()
    }

}