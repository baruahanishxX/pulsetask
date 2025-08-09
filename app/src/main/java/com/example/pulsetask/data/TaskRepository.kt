package com.example.pulsetask.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val dao: TaskDao) {
    fun allTasks(): Flow<List<TaskEntity>> = dao.getAllFlow()
    suspend fun upsert(task: TaskEntity) = dao.upsert(task)
    suspend fun setCompleted(id: String, completed: Boolean) = dao.setCompleted(id, completed)
}
