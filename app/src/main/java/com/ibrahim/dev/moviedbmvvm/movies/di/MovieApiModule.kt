package com.ibrahim.dev.moviedbmvvm.movies.di

import com.ibrahim.dev.moviedbmvvm.movies.data.network.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class MovieApiModule() {

    @Provides
    fun providerMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

}