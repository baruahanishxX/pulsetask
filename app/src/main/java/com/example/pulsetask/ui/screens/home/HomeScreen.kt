package com.example.pulsetask.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulsetask.data.TaskEntity
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(onCreate: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text("Today", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            // Placeholder tasks
            val tasks = sampleTasks()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(tasks) { t ->
                    TaskCard(task = t, onClick = {})
                }
            }
        }
        FloatingActionButton(
            onClick = onCreate,
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Create task")
        }
    }
}

@Composable
fun TaskCard(task: TaskEntity, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable { onClick() }) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(8.dp).background(colorForPriority(task.priority)))
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(task.title, style = MaterialTheme.typography.titleMedium)
                task.description?.let {
                    Spacer(Modifier.height(4.dp))
                    Text(it, style = MaterialTheme.typography.bodyLarge, maxLines = 1)
                }
            }
            Text(if (task.dueEpochMillis != null) "Soon" else "No date", style = MaterialTheme.typography.labelSmall)
        }
    }
}

private fun sampleTasks(): List<TaskEntity> {
    return listOf(
        TaskEntity(id = "1", title = "Finish project doc", description = "Write abstract and intro", dueEpochMillis = null, priority = 2, tagsCsv = "work,urgent"),
        TaskEntity(id = "2", title = "Buy groceries", description = "Milk, eggs, bread", dueEpochMillis = null, priority = 0, tagsCsv = "personal"),
        TaskEntity(id = "3", title = "Practice beats", description = "Make trap pattern", dueEpochMillis = null, priority = 1, tagsCsv = "music")
    )
}

private fun colorForPriority(p: Int) = when(p) {
    2 -> MaterialTheme.colorScheme.primary
    1 -> MaterialTheme.colorScheme.primaryContainer
    else -> MaterialTheme.colorScheme.secondary
}
