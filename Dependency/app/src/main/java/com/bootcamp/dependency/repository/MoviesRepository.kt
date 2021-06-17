package com.bootcamp.dependency.repository

import com.bootcamp.dependency.DB.dao.MovieDao
import com.bootcamp.dependency.DB.entities.MovieStorageEntity
import com.bootcamp.dependency.Utils.DataState
import com.bootcamp.dependency.models.MovieDetailResponse
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

    suspend fun getMovies(): Flow<DataState<List<MovieStorageEntity>>> = flow {
        emit(DataState.Loading)

        try {
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
                    val moviesFromDB = movieDao.getMoviesNowPlaying()
                    emit(DataState.Success(moviesFromDB))
                }
            }
        }catch (e:Exception){
            val exception = e
            val moviesFromDB = movieDao.getMoviesNowPlaying()
            emit(DataState.Success(moviesFromDB))
        }

    }.catch { error ->
        emit(DataState.Error(Exception(error)))
    }

    suspend fun getMovieDetail(id:Long): Flow<DataState<MovieDetailResponse>> = flow {
        emit(DataState.Loading)

        try {
            val movieDetailResponse = retrofitService.getMovieDetail(id)
            if (movieDetailResponse.isSuccessful){
                movieDetailResponse.body()?.let { movieDetail ->
                    emit(DataState.Success(movieDetail))
                }
            }
        }catch (e:Exception){
            val exception = e
            val moviesFromDB = movieDao.getMoviesNowPlaying()
            //emit(DataState.Success(moviesFromDB))
        }

    }.catch { error ->
        emit(DataState.Error(Exception(error)))
    }
}