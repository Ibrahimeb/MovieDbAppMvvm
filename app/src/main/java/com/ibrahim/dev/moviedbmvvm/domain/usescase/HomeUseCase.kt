package com.ibrahim.dev.moviedbmvvm.domain.usescase

import com.ibrahim.dev.moviedbmvvm.data.network.MovieApi
import com.ibrahim.dev.moviedbmvvm.data.network.TvShowApi
import com.ibrahim.dev.moviedbmvvm.data.repository.MovieRepository
import com.ibrahim.dev.moviedbmvvm.data.repository.TvShowRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository
) {



}