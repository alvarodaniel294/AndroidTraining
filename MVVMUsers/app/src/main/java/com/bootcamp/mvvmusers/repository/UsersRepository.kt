package com.bootcamp.mvvmusers.repository

import android.util.Log
import com.bootcamp.mvvmusers.model.User
import com.bootcamp.mvvmusers.retrofit.UsersService
import com.bootcamp.mvvmusers.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UsersRepository
constructor(
    private val usersService: UsersService
) {
    suspend fun getUsers(): Flow<DataState<List<User>>> = flow {
        emit(DataState.Loading)

        try {
            Log.d("MAIN", "MAIN2")
            val networkUsers = usersService.getAllUsers()
            Log.d("MAIN", networkUsers.toString())
            if (networkUsers.isSuccessful) {
                Log.d("MAIN", "MAIN3")
                networkUsers.body()?.let { response ->
                    emit(DataState.Success(response))
                }
            }
        }catch (e:Exception){
            emit(DataState.Error(e))
        }

    }.catch { error ->
        emit(DataState.Error(Exception(error)))
    }
}