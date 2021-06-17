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
import com.bootcamp.dependency.DB.entities.MovieStorageEntity
import com.bootcamp.dependency.R
import com.bootcamp.dependency.UI.viewmodels.MainViewModel
import com.bootcamp.dependency.Utils.Constants
import com.bootcamp.dependency.Utils.DataState
import com.bootcamp.dependency.databinding.FragmentMainBinding
import com.bootcamp.dependency.databinding.FragmentMovieDetailBinding
import com.bootcamp.dependency.models.MovieDetailResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MovieDetailFragment : Fragment() {

    var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    private var movieId = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieId = arguments?.getLong("MOVIE_ID", 0L) ?: 0L
//        val id = savedInstanceState?.getLong("MOVIE_ID", 0) ?: 0

        if (movieId != 0L){
            viewModel.getMovieDetail(movieId)
        }
        susbscribeObservers()
    }

    private fun susbscribeObservers() {
        viewModel.movieDetail.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<MovieDetailResponse> -> {
                    setUpMovie(dataState.data)
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

    private fun setUpMovie(movie: MovieDetailResponse) {
        binding.movieTitle.text = movie.originalTitle
        binding.posterImage.let {
            Glide
                .with(requireContext())
                .load("${Constants.IMAGE_PATH}${movie.backdropPath}")
                .centerCrop()
//            .placeholder(R.drawable.loading_spinner)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(it)
        }
        binding.movieImage.let {
            Glide
                .with(requireContext())
                .load("${Constants.IMAGE_PATH}${movie.posterPath}")
                .centerCrop()
//            .placeholder(R.drawable.loading_spinner)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(it)
        }

        binding.movieOverview.text = movie.overview
        binding.movieGenres.text = movie.genres.joinToString(" | ") { it.name }
        binding.moviesTotalVotes.text = getString(R.string.total_votes, movie.voteCount.toString())
        binding.averageVotes.text = getString(R.string.average_votes, movie.voteAverage.toString())

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}