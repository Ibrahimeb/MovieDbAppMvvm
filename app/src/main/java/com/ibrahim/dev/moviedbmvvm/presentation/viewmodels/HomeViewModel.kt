package com.ibrahim.dev.moviedbmvvm.presentation.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.dev.moviedbmvvm.domain.usescase.HomeUseCase
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScoped
class HomeViewModel @ViewModelInject constructor(
    private val useCase: HomeUseCase
) : ViewModel() {

    private val TAG = this::class.java.simpleName

    private val _requestHomeLiveData = MutableLiveData<DataHomeResponse>()
    val requestHomeLiveData: LiveData<DataHomeResponse> get() = _requestHomeLiveData

    private val _progressBarLiveData = MutableLiveData<Boolean>()
    val progressBarLiveData: LiveData<Boolean> get() = _progressBarLiveData

    fun requestMovie() {
        getPopularMovie()
        getTopRateMovie()
        getUpComingMovie()
    }

    fun requestTvShow() {
        getPopularTvShow()
        getTopRateTvShow()
        getUpOnAirTvShow()
    }

    private fun getPopularMovie() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                _progressBarLiveData.value = false
                useCase.getPopularMovie().collect {
                    _requestHomeLiveData.value =
                        DataHomeResponse.MovieResponse(it, "Popular Movies")
                }
            } catch (e: Throwable) {
                _progressBarLiveData.value = false
                Log.e(TAG, "getTopRateMovie:  ${e.message}")
            }
        }
    }

    private fun getTopRateMovie() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                _progressBarLiveData.value = false
                useCase.getTopRateMovie().collect {
                    _requestHomeLiveData.value =
                        DataHomeResponse.MovieResponse(it, "Top Rate Movies")
                }
            } catch (e: Throwable) {
                _progressBarLiveData.value = false
                Log.e(TAG, "getTopRateMovie:  ${e.message}")
            }
        }

    }

    private fun getUpComingMovie() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                _progressBarLiveData.value = false
                useCase.getUpComingMovie().collect {
                    _requestHomeLiveData.value =
                        DataHomeResponse.MovieResponse(it, "Up Coming Movies")
                }
            } catch (e: Throwable) {
                _progressBarLiveData.value = false
                Log.e(TAG, "getUpComingMovie:  ${e.message}")
            }
        }
    }

    private fun getPopularTvShow() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                _progressBarLiveData.value = false
                useCase.getPopularTvShow().collect {
                    _requestHomeLiveData.value =
                        DataHomeResponse.TvShowResponse(it, "Popular Tv Show")
                }
            } catch (e: Throwable) {
                _progressBarLiveData.value = false
                Log.e(TAG, "getPopularTvShow: ${e.message}")
            }
        }
    }

    private fun getTopRateTvShow() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                _progressBarLiveData.value = false
                useCase.getTopRateTvShow().collect {
                    _requestHomeLiveData.value =
                        DataHomeResponse.TvShowResponse(it, "Top Rate Tv Show")
                }
            } catch (e: Throwable) {
                _progressBarLiveData.value = false
                Log.e(TAG, "getTopRateTvShow: ${e.message}")
            }
        }
    }

    private fun getUpOnAirTvShow() {
        _progressBarLiveData.value = true
        viewModelScope.launch {
            try {
                _progressBarLiveData.value = false
                useCase.getUpOnAirTvShow().collect {
                    _requestHomeLiveData.value =
                        DataHomeResponse.TvShowResponse(it, "On Air Tv Show")
                }
            } catch (e: Throwable) {
                _progressBarLiveData.value = false
                Log.e(TAG, "getUpOnAirTvShow: ${e.message}")
            }
        }
    }
}