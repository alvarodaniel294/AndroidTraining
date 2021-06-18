package com.bootcamp.mvvmusers.DI

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
    fun provideUsersRepository( retrofit: UsersService ):UsersRepository{
        return UsersRepository(retrofit)
    }

}