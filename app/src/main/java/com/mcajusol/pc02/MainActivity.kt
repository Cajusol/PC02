package com.mcajusol.pc02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mcajusol.pc02.presentation.auth.navigation.AppNavGraph
import com.mcajusol.pc02.ui.theme.PC01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PC01Theme {
                AppNavGraph()
            }
        }
    }
}

