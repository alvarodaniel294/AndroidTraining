package com.bootcamp.dependency.repository

import com.bootcamp.dependency.DB.dao.MovieDao
import com.bootcamp.dependency.DB.entities.MovieStorageEntity
import com.bootcamp.dependency.Utils.DataState
import com.bootcamp.dependency.models.MoviesResponse
import com.bootcamp.dependency.retrofit.MoviesService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MoviesRepository
constructor(
    private val retrofitService: MoviesService,
    private val movieDao: MovieDao
) {

    suspend fun getMovies(): Flow<DataState<MoviesResponse>> = flow {
        emit(DataState.Loading)

        val networkMovies = retrofitService.getNowPlayingMovies()
        if (networkMovies.isSuccessful) {
            networkMovies.body()?.let { response ->
                response.moviesList.forEach { movieResponse ->
                    val movie = MovieStorageEntity(
                        movieResponse.id,
                        movieResponse.language,
                        movieResponse.title,
                        movieResponse.backdropPath,
                        movieResponse.overview,
                        movieResponse.poster
                    )
                    movieDao.saveMovie(movie)
                }
                emit(DataState.Success(response))
            }
        }
    }.catch { error ->
        emit(DataState.Error(Exception(error)))
    }
}