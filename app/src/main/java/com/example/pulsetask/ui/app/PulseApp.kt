package com.example.pulsetask.ui.app

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.pulsetask.ui.nav.MainNavHost
import com.example.pulsetask.ui.theme.PulseTheme

@Composable
fun PulseApp() {
    PulseTheme {
        Surface {
            MainNavHost()
        }
    }
}
