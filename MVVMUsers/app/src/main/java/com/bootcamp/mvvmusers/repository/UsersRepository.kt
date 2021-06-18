package com.bootcamp.mvvmusers.repository

import com.bootcamp.mvvmusers.DB.dao.UserDao
import com.bootcamp.mvvmusers.DB.entities.UserStorageEntity
import com.bootcamp.mvvmusers.retrofit.UsersService
import com.bootcamp.mvvmusers.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UsersRepository
constructor(
    private val usersService: UsersService,
    private val userDao: UserDao
) {
    suspend fun getUsers(): Flow<DataState<List<UserStorageEntity>>> = flow {
        emit(DataState.Loading)

        try {
            val networkUsers = usersService.getAllUsers()
            if (networkUsers.isSuccessful) {
                networkUsers.body()?.let { response ->
                    response.forEach { userResponse ->
                        val user = UserStorageEntity(
                            userResponse.id,
                            userResponse.name,
                            userResponse.username,
                            userResponse.email,
                            userResponse.phone,
                            userResponse.website
                        )
                        userDao.saveUser(user)
                    }
                    val moviesFromDB = userDao.getUsers()
                    emit(DataState.Success(moviesFromDB))
                }
            }
        }catch (e:Exception){
            val moviesFromDB = userDao.getUsers()
            emit(DataState.Success(moviesFromDB))
        }

    }.catch { error ->
        emit(DataState.Error(Exception(error)))
    }
}