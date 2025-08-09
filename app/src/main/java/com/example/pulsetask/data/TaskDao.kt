package com.example.pulsetask.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY dueEpochMillis ASC")
    fun getAllFlow(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(task: TaskEntity)

    @Query("UPDATE tasks SET isCompleted = :completed, updatedAt = :updatedAt WHERE id = :id")
    suspend fun setCompleted(id: String, completed: Boolean, updatedAt: Long = System.currentTimeMillis())
}
