package com.bootcamp.dependency.UI.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.dependency.DB.entities.MovieStorageEntity
import com.bootcamp.dependency.Utils.DataState
import com.bootcamp.dependency.models.MovieDetailResponse
import com.bootcamp.dependency.models.MoviesResponse
import com.bootcamp.dependency.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    val repository: MoviesRepository
):ViewModel() {



    private val _moviesDataState:MutableLiveData<DataState<List<MovieStorageEntity>>> = MutableLiveData()
    val moviesDataState:LiveData<DataState<List<MovieStorageEntity>>>
        get() = _moviesDataState

    private val _upcomingMoviesDataState:MutableLiveData<DataState<List<MovieStorageEntity>>> = MutableLiveData()
    val upcomingMoviesDataState:LiveData<DataState<List<MovieStorageEntity>>>
        get() = _upcomingMoviesDataState

    private val _topRatedMoviesDataState:MutableLiveData<DataState<List<MovieStorageEntity>>> = MutableLiveData()
    val topRatedMoviesDataState:LiveData<DataState<List<MovieStorageEntity>>>
        get() = _topRatedMoviesDataState

    private val _movieDetail:MutableLiveData<DataState<MovieDetailResponse>> = MutableLiveData()
    val movieDetail:LiveData<DataState<MovieDetailResponse>>
        get() = _movieDetail


    fun getMoviesFromServer(event: MainViewModelStateEvent){
        viewModelScope.launch {
            when(event){
                is MainViewModelStateEvent.GetMoviesEvent ->{
                    repository.getMovies().onEach { dataState ->
                        _moviesDataState.value = dataState
                    }.launchIn(viewModelScope)

                    repository.getUpComingMovies().onEach { dataState ->
                        _upcomingMoviesDataState.value = dataState
                    }.launchIn(viewModelScope)

                    repository.getTopRatedMovies().onEach { dataState ->
                        _topRatedMoviesDataState.value = dataState
                    }.launchIn(viewModelScope)
                }
                else ->{

                }
            }
        }
    }

    fun getMovieDetail(id:Long){
        viewModelScope.launch {
            repository.getMovieDetail(id).onEach {
                _movieDetail.value = it
            }.launchIn(viewModelScope)
         }
    }


}

sealed class MainViewModelStateEvent{
    object GetMoviesEvent:MainViewModelStateEvent()

    object None: MainViewModelStateEvent()
}