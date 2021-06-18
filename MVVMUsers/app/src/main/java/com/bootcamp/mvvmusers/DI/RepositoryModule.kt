package com.bootcamp.mvvmusers.DI

import com.bootcamp.mvvmusers.DB.dao.UserDao
import com.bootcamp.mvvmusers.repository.UsersRepository
import com.bootcamp.mvvmusers.retrofit.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(usersService: UsersService, userDao: UserDao): UsersRepository {
        return UsersRepository(usersService, userDao)
    }
}