package com.bootcamp.mvvmusers.DI

import android.content.Context
import androidx.room.Room
import com.bootcamp.mvvmusers.DB.UsersDatabase
import com.bootcamp.mvvmusers.DB.dao.UserDao
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
    fun provideMovieDB(@ApplicationContext context: Context): UsersDatabase {
        return Room.databaseBuilder(
            context,
            UsersDatabase::class.java,
            UsersDatabase.NAME.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    }

    @Singleton
    @Provides
    fun provideMovieDao(usersDatabase: UsersDatabase): UserDao {
        return usersDatabase.userDao()
    }
}