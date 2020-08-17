package com.ibrahim.dev.moviedbmvvm.domain.usescase

import com.ibrahim.dev.moviedbmvvm.data.network.MovieApi
import com.ibrahim.dev.moviedbmvvm.data.network.TvShowApi
import com.ibrahim.dev.moviedbmvvm.data.repository.MovieRepository
import com.ibrahim.dev.moviedbmvvm.data.repository.TvShowRepository
import com.ibrahim.dev.moviedbmvvm.domain.models.movie.MovieModels
import com.ibrahim.dev.moviedbmvvm.domain.models.tvshow.TvModels
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository
) {

    fun getPopularMovie(): Flow<MovieModels> {
        return movieRepository.getPopularMovie()
    }

    fun getTopRateMovie(): Flow<MovieModels> {
        return movieRepository.getMovieTopRated()
    }

    fun getUpComingMovie(): Flow<MovieModels> {
        return movieRepository.getMovieUpComing()
    }

    fun getPopularTvShow(): Flow<TvModels> {
        return tvShowRepository.getTvPopular()
    }

    fun getTopRateTvShow(): Flow<TvModels> {
        return tvShowRepository.getTvTopRated()
    }

    fun getUpOnAirTvShow(): Flow<TvModels> {
        return tvShowRepository.getTvOnAir()
    }

}