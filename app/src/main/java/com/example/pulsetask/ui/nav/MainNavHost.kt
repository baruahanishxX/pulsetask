package com.example.pulsetask.ui.nav

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pulsetask.ui.screens.calendar.CalendarScreen
import com.example.pulsetask.ui.screens.create.CreateTaskScreen
import com.example.pulsetask.ui.screens.home.HomeScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { SmallTopAppBar(title = { Text("PulseTask") }) },
        floatingActionButton = { /* handled inside Home */ }
    ) { padding ->
        NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(padding)) {
            composable("home") { HomeScreen(onCreate = { navController.navigate("create") }) }
            composable("create") { CreateTaskScreen(onSaved = { navController.popBackStack() }) }
            composable("calendar") { CalendarScreen() }
        }
    }
}
