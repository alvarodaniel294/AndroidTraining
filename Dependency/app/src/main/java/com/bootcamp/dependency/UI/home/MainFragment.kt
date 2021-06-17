package com.bootcamp.dependency.UI.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.dependency.DB.entities.MovieStorageEntity
import com.bootcamp.dependency.R
import com.bootcamp.dependency.UI.viewmodels.MainViewModel
import com.bootcamp.dependency.UI.viewmodels.MainViewModelStateEvent
import com.bootcamp.dependency.Utils.DataState
import com.bootcamp.dependency.databinding.FragmentMainBinding
import com.bootcamp.dependency.interfaces.MovieListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(), MovieListener {

    companion object {
        const val TAG = "MainFragment"
    }

    var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var nowPlayingAdapter: HomeMovieAdapter
    lateinit var upcomingAdapter: HomeMovieAdapter
    lateinit var topRatedAdapter: HomeMovieAdapter


    private val viewModel: MainViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMoviesFromServer(MainViewModelStateEvent.GetMoviesEvent)
        subscribeObservers()
        setupNowPlayingRecycler()
        setupUpComingRecycler()
        setupTopRatedRecycler()
    }

    private fun setupTopRatedRecycler() {
        binding.topRatedRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        topRatedAdapter = HomeMovieAdapter(this)
        binding.topRatedRecycler.adapter = topRatedAdapter
    }

    private fun setupUpComingRecycler() {
        binding.upcomingRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        upcomingAdapter = HomeMovieAdapter(this)
        binding.upcomingRecycler.adapter = upcomingAdapter
    }

    private fun setupNowPlayingRecycler() {
        binding.nowPlayingRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        nowPlayingAdapter = HomeMovieAdapter(this)
        binding.nowPlayingRecycler.adapter = nowPlayingAdapter
    }

    private fun subscribeObservers() {
        viewModel.moviesDataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<MovieStorageEntity>> -> {
                    dataState.data.forEach { movie ->
                        Log.d(TAG, movie.title)
                    }
                    nowPlayingAdapter.movies = dataState.data
                }
                is DataState.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.upcomingMoviesDataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<MovieStorageEntity>> -> {
                    dataState.data.forEach { movie ->
                        Log.d(TAG, movie.title)
                    }
                    upcomingAdapter.movies = dataState.data
                }
                is DataState.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.topRatedMoviesDataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<MovieStorageEntity>> -> {
                    dataState.data.forEach { movie ->
                        Log.d(TAG, movie.title)
                    }
                    topRatedAdapter.movies = dataState.data
                }
                is DataState.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onMovieTap(id: Long) {

        val bundle = Bundle()
        bundle.putLong("MOVIE_ID", id)
        findNavController().navigate(R.id.action_mainFragment_to_movieDetailFragment, bundle)
    }

}