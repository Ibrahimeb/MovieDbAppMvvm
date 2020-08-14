package com.ibrahim.dev.moviedbmvvm.movies.di

import com.ibrahim.dev.moviedbmvvm.app.di.ApiKey
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
    fun provideMovieRepository(movieApi: MovieApi, @ApiKey apiKey: String): MovieRepository {
        return MovieRepository(movieApi, apiKey)
    }

}