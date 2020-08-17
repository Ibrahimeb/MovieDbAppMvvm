package com.ibrahim.dev.moviedbmvvm.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ibrahim.dev.moviedbmvvm.app.di.BaseUrl
import com.ibrahim.dev.moviedbmvvm.app.utils.show
import com.ibrahim.dev.moviedbmvvm.databinding.FragmentMovieListBinding
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.DataItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.GenericAdapter
import com.ibrahim.dev.moviedbmvvm.presentation.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MovieListFragment : Fragment() {

    @BaseUrl
    @Inject
    lateinit var url: String

    private val viewModel: MovieViewModel by viewModels()

    private lateinit var binding: FragmentMovieListBinding

    private lateinit var adapterGeneric: GenericAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPopularMovie()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeLiveData()
        Log.i(this::class.java.simpleName, "onViewCreated: --> url base inject $url")
    }

    private fun initRecyclerView() {
        val manager = GridLayoutManager(activity, 2)
        adapterGeneric = GenericAdapter {}
        binding.recyclerview.apply {
            layoutManager = manager
            adapter = adapterGeneric
        }
    }

    private fun subscribeLiveData() {
        viewModel.movieLiveData.observe(viewLifecycleOwner, Observer { movieModels ->
            val listItem = movieModels.pageMovieModels.map {
                DataItem.MovieItem(it)
            }
            adapterGeneric.addHeaderAndSubmitList(listItem)
        })
        viewModel.progressBarLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.show(it)
        })
    }
}