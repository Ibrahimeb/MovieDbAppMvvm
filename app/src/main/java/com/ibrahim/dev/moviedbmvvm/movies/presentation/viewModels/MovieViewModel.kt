package com.ibrahim.dev.moviedbmvvm.movies.presentation.viewModels

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
    private val repository: MovieRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
):ViewModel() {
    private val _movieLiveData = MutableLiveData<ResponseMovie>()
    val movieLiveData: LiveData<ResponseMovie> get() = _movieLiveData

    fun getPopularMovie() {
        viewModelScope.launch {
        repository.getPopularMovie().collect {
            _movieLiveData.value = it
        }

        }

    }

}