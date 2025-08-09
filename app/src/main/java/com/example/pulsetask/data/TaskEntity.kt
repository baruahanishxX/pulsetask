package com.example.pulsetask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val id: String = java.util.UUID.randomUUID().toString(),
    val title: String,
    val description: String?,
    val dueEpochMillis: Long?,
    val priority: Int,
    val tagsCsv: String?,
    val isCompleted: Boolean = false,
    val pendingSync: Boolean = true,
    val updatedAt: Long = System.currentTimeMillis()
) {
    fun tags(): List<String> = tagsCsv?.split(',')?.map { it.trim() }?.filter { it.isNotEmpty() } ?: emptyList()
}
