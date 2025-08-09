package com.example.pulsetask.di

import android.content.Context
import androidx.room.Room
import com.example.pulsetask.data.AppDatabase
import com.example.pulsetask.data.TaskDao
import com.example.pulsetask.data.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "pulsetask-db").build()
    }

    @Provides
    fun provideTaskDao(db: AppDatabase): TaskDao = db.taskDao()

    @Provides
    @Singleton
    fun provideRepository(dao: TaskDao) = TaskRepository(dao)
}
