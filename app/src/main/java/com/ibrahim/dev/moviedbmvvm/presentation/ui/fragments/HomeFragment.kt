package com.ibrahim.dev.moviedbmvvm.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.dev.moviedbmvvm.databinding.FragmentHomeBinding
import com.ibrahim.dev.moviedbmvvm.domain.models.movie.MovieModels
import com.ibrahim.dev.moviedbmvvm.domain.models.tvshow.TvModels
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.DataItem
import com.ibrahim.dev.moviedbmvvm.presentation.adapter.GenericAdapter
import com.ibrahim.dev.moviedbmvvm.presentation.viewmodels.DataHomeResponse
import com.ibrahim.dev.moviedbmvvm.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var listResult: MutableList<DataItem> = mutableListOf()
    private val viewModel: HomeViewModel by viewModels()

    lateinit var binding: FragmentHomeBinding

    lateinit var homeAdapter: GenericAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.requestMovie()
        viewModel.requestTvShow()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeLiveData()
    }

    private fun initRecyclerView() {
        homeAdapter = GenericAdapter { }

        binding.recyclerview.apply {
            adapter = homeAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

    }

    private fun subscribeLiveData() {
        viewModel.requestHomeLiveData.observe(viewLifecycleOwner, Observer {
            handlerEvent(it)
        })
    }

    private fun handlerEvent(event: DataHomeResponse) {
        when (event) {
            is DataHomeResponse.MovieResponse -> mapMovieSection(
                event.movieResponse,
                event.headerText
            )
            is DataHomeResponse.TvShowResponse -> mapTvSection(
                event.tvShowResponse,
                event.headerText
            )
        }
    }

    private fun mapTvSection(tvShowResponse: TvModels, headerText: String) {
        listResult.add(DataItem.ItemHeader(headerText))
        listResult.add(
            DataItem.SubListHomeItemTvShow(tvShowResponse.tvListItemListModels)
        )

        homeAdapter.addHeaderAndSubmitList(listResult)
    }

    private fun mapMovieSection(movieResponse: MovieModels, headerText: String) {
        listResult.add(DataItem.ItemHeader(headerText))
        listResult.add(
            DataItem.SubListHomeItemMovie(movieResponse.pageMovieModels)
        )
        homeAdapter.addHeaderAndSubmitList(listResult)
    }

}