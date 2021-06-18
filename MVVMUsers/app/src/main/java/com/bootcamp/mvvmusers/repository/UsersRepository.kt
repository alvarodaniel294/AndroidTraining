package com.bootcamp.mvvmusers.repository

import com.bootcamp.mvvmusers.DB.dao.UserDao
import com.bootcamp.mvvmusers.DB.entities.UserStorageEntity
import com.bootcamp.mvvmusers.Utils.DataState
import com.bootcamp.mvvmusers.retrofit.UsersService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UsersRepository
constructor(
    private val retrofitService: UsersService,
    private val userDao: UserDao
) {

    suspend fun getMovies(): Flow<DataState<List<UserStorageEntity>>> = flow {
        emit(DataState.Loading)

        try {
            val network = retrofitService.getUsers()
            if (network.isSuccessful) {
                network.body()?.let { response ->
                    response.usersList.forEach { userResponse ->
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
            val exception = e
        }

    }.catch { error ->

    }

}