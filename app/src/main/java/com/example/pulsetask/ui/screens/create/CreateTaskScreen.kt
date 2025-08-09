package com.example.pulsetask.ui.screens.create

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun CreateTaskScreen(onSaved: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf(1) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Create Task", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title") }, singleLine = true, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = desc, onValueChange = { desc = it }, label = { Text("Description") }, modifier = Modifier.fillMaxWidth().heightIn(min = 120.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = priority==0, onClick = { priority = 0 }) { Text("Low") }
            FilterChip(selected = priority==1, onClick = { priority = 1 }) { Text("Medium") }
            FilterChip(selected = priority==2, onClick = { priority = 2 }) { Text("High") }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = onSaved, modifier = Modifier.fillMaxWidth()) { Text("Save") }
    }
}
