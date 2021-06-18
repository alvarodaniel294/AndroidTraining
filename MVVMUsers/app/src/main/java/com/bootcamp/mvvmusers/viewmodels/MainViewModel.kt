package com.bootcamp.mvvmusers.UI.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.mvvmusers.DB.entities.UserStorageEntity
import com.bootcamp.mvvmusers.Utils.DataState
import com.bootcamp.mvvmusers.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    val repository: UsersRepository
):ViewModel() {

    private val _usersDataState:MutableLiveData<DataState<List<UserStorageEntity>>> =
        MutableLiveData()
    val usersDataState:LiveData<DataState<List<UserStorageEntity>>>
        get() = _usersDataState


    fun getUsersFromServer(event: MainViewModelStateEvent){
        viewModelScope.launch {
            when(event){
                is MainViewModelStateEvent.GetUsersEvent ->{
                    repository.getMovies().onEach { dataState ->
                        _usersDataState.value = dataState
                    }.launchIn(viewModelScope)
                }
                else ->{

                }
            }
        }
    }

    fun getUsersFromServer() {
        viewModelScope.launch {
            repository.getMovies().onEach { dataState ->
                _usersDataState.value = dataState
            }.launchIn(viewModelScope)
        }
    }
}

sealed class MainViewModelStateEvent{
    object GetUsersEvent:MainViewModelStateEvent()

    object None: MainViewModelStateEvent()
}