package com.ibrahim.dev.moviedbmvvm.movies.di

import com.ibrahim.dev.moviedbmvvm.movies.data.network.MovieApi
import com.ibrahim.dev.moviedbmvvm.movies.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class MovieRepositoryModule {

    @Provides
    fun provideMovieRepository(movieApi: MovieApi): MovieRepository {
        return MovieRepository(movieApi)
    }

}