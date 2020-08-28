package com.ibrahim.dev.moviedbmvvm.presentation.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.dev.moviedbmvvm.data.entities.movie.ResponseMovie
import com.ibrahim.dev.moviedbmvvm.data.repository.MovieRepository
import com.ibrahim.dev.moviedbmvvm.data.repository.TvShowRepository
import com.ibrahim.dev.moviedbmvvm.domain.models.movie.MovieModels
import com.ibrahim.dev.moviedbmvvm.domain.models.tvshow.TvModels
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ActivityScoped
class MovieViewModel @ViewModelInject constructor(
    private val repository: MovieRepository,
    private val repositoryTv: TvShowRepository
) : ViewModel() {
    private val _movieLiveData = MutableLiveData<MovieModels>()
    val movieLiveData: LiveData<MovieModels> get() = _movieLiveData

    private val _tvShowLiveData = MutableLiveData<TvModels>()
    val tvShowLiveData: LiveData<TvModels> get() = _tvShowLiveData

    private val _progressBarLiveData = MutableLiveData<Boolean>()
    val progressBarLiveData: LiveData<Boolean> get() = _progressBarLiveData

    fun getPopularMovie() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                repository.getPopularMovie().collect {
                    _progressBarLiveData.value = false
                    _movieLiveData.value = it
                }
            } catch (e: Exception) {
                _progressBarLiveData.value = false
                Log.e(this::class.java.simpleName, "getPopularMovie: ${e.message}")
            }
        }
    }

    fun getTopRateMovie() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                repository.getMovieTopRated().collect {
                    _progressBarLiveData.value = false
                    _movieLiveData.value = it
                }
            } catch (e: Exception) {
                _progressBarLiveData.value = false
                Log.e(this::class.java.simpleName, "getPopularMovie: ${e.message}")
            }
        }
    }

    fun getUpComingMovie() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                repository.getMovieUpComing().collect {
                    _progressBarLiveData.value = false
                    _movieLiveData.value = it
                }
            } catch (e: Exception) {
                _progressBarLiveData.value = false
                Log.e(this::class.java.simpleName, "getPopularMovie: ${e.message}")
            }
        }
    }

    fun getPopularTv() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                repositoryTv.getTvPopular().collect {
                    _progressBarLiveData.value = false
                    _tvShowLiveData.value = it
                }
            } catch (e: Exception) {
                _progressBarLiveData.value = false
                Log.e(this::class.java.simpleName, "getPopularTv: ${e.message}")
            }
        }
    }

    fun getTopRateTv() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                repositoryTv.getTvTopRated().collect {
                    _progressBarLiveData.value = false
                    _tvShowLiveData.value = it
                }
            } catch (e: Exception) {
                _progressBarLiveData.value = false
                Log.e(this::class.java.simpleName, "getTopRateTv: ${e.message}")
            }
        }
    }

    fun getOnAirTvShow() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                repositoryTv.getTvOnAir().collect {
                    _progressBarLiveData.value = false
                    _tvShowLiveData.value = it
                }
            } catch (e: Exception) {
                _progressBarLiveData.value = false
                Log.e(this::class.java.simpleName, "getOnAirTvShow: ${e.message}")
            }
        }
    }

}