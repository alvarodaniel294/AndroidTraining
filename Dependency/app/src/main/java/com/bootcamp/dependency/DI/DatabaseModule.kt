package com.bootcamp.dependency.DI

import android.content.Context
import androidx.room.Room
import com.bootcamp.dependency.DB.MoviesDatabase
import com.bootcamp.dependency.DB.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDB(@ApplicationContext context: Context): MoviesDatabase {
        return Room.databaseBuilder(
            context,
            MoviesDatabase::class.java,
            MoviesDatabase.NAME.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    }

    @Singleton
    @Provides
    fun provideMovieDao(moviesDatabase: MoviesDatabase): MovieDao {
        return moviesDatabase.movieDao()
    }
}