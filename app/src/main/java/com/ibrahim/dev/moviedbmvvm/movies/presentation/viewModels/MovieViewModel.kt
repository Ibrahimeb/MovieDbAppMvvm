package com.ibrahim.dev.moviedbmvvm.movies.presentation.viewModels

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.dev.moviedbmvvm.movies.data.entities.ResponseMovie
import com.ibrahim.dev.moviedbmvvm.movies.data.repository.MovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieViewModel @ViewModelInject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    private val _movieLiveData = MutableLiveData<ResponseMovie>()
    val movieLiveData: LiveData<ResponseMovie> get() = _movieLiveData

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
}