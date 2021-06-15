package com.bootcamp.dependency.UI.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.dependency.Utils.DataState
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

    private val _moviesDataState:MutableLiveData<DataState<MoviesResponse>> = MutableLiveData()
    val moviesDataState:LiveData<DataState<MoviesResponse>>
        get() = _moviesDataState


    fun getMoviesFromServer(event: MainViewModelStateEvent){
        viewModelScope.launch {
            when(event){
                is MainViewModelStateEvent.GetMoviesEvent ->{
                    repository.getMovies().onEach { dataState ->
                        _moviesDataState.value = dataState
                    }.launchIn(viewModelScope)
                }
                else ->{

                }
            }
        }
    }


}

sealed class MainViewModelStateEvent{
    object GetMoviesEvent:MainViewModelStateEvent()
    object None: MainViewModelStateEvent()
}