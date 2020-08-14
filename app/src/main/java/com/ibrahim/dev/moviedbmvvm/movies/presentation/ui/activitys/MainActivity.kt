package com.ibrahim.dev.moviedbmvvm.movies.presentation.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.ibrahim.dev.moviedbmvvm.R
import com.ibrahim.dev.moviedbmvvm.movies.presentation.viewModels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MovieViewModel  by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPopularMovie()
        viewModel.movieLiveData.observe(this, Observer {
            textView.text = it.id.toString()
        })
    }
}