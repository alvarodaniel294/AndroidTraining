package com.bootcamp.dependency.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import com.bootcamp.dependency.R
import com.bootcamp.dependency.UI.viewmodels.MainViewModel
import com.bootcamp.dependency.UI.viewmodels.MainViewModelStateEvent
import com.bootcamp.dependency.Utils.DataState
import com.bootcamp.dependency.models.MoviesResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        const val TAG = "MainFragment"
    }

    private val viewModel:MainViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMoviesFromServer(MainViewModelStateEvent.GetMoviesEvent)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.moviesDataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<MoviesResponse> ->{
                    dataState.data.moviesList.forEach { movie ->
                        Log.d(TAG, movie.title)
                    }
                }
                is DataState.Error ->{
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

}