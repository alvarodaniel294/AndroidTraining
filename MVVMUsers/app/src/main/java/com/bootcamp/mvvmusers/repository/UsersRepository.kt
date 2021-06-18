package com.bootcamp.mvvmusers.repository

import com.bootcamp.mvvmusers.Utils.DataState
import com.bootcamp.mvvmusers.model.User
import com.bootcamp.mvvmusers.model.UserList
import com.bootcamp.mvvmusers.retrofit.UsersService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class UsersRepository
constructor(
    private val retrofitService: UsersService
){
    suspend fun getMovies(): Flow<DataState<UserList>> = flow {
        emit(DataState.Loading)

        val networkUsers = retrofitService.getUsers()
        if (networkUsers.isSuccessful){
            networkUsers.body()?.let {
                emit(DataState.Success(it))
            }
        }
    }.catch {  error ->
        emit(DataState.Error(Exception(error)))
    }
}