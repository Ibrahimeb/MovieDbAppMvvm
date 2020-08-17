package com.ibrahim.dev.moviedbmvvm.data.repository

import com.ibrahim.dev.moviedbmvvm.app.di.ApiKey
import com.ibrahim.dev.moviedbmvvm.data.network.TvShowApi
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TvShowRepository @Inject constructor(
    private val api: TvShowApi,
    @ApiKey private val apiKey: String
) {

    fun getTvPopular() = flow {
        emit(api.getTvPopular(apiKey).toModel())
    }

    fun getTvOnAir() = flow {
        emit(api.getTvOnAir(apiKey).toModel())
    }

    fun getTvTopRated() = flow {
        emit(api.getTvtopRated(apiKey).toModel())
    }

    fun getTvShowCategory() = flow {
        emit(api.getTvShowCategory(apiKey).toModel())
    }

}