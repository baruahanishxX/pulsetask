package com.example.pulsetask.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pulsetask.data.TaskEntity
import com.example.pulsetask.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val repo: TaskRepository) : ViewModel() {
    val tasks: StateFlow<List<TaskEntity>> = repo.allTasks()
        .map { it }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun save(task: TaskEntity) {
        viewModelScope.launch { repo.upsert(task) }
    }

    fun complete(id: String) {
        viewModelScope.launch { repo.setCompleted(id, true) }
    }
}
