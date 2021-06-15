package com.bootcamp.dependency.DI

import com.bootcamp.dependency.DB.dao.MovieDao
import com.bootcamp.dependency.repository.MoviesRepository
import com.bootcamp.dependency.retrofit.MoviesService
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
    fun provideMoviesRepository( retrofit: MoviesService, movieDao:MovieDao ):MoviesRepository{
        return MoviesRepository(retrofit, movieDao )
    }

}