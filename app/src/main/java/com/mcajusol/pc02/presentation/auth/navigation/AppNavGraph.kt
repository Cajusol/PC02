package com.mcajusol.pc02.presentation.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mcajusol.pc02.presentation.api.ApiScreen
import com.mcajusol.pc02.presentation.auth.LoginScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "football")
    {
        composable("login") { LoginScreen(navController) }
        composable ("football") {
            DrawerScaffold(navController) {
                ApiScreen()
            }
        }
        composable("home") {
           // DrawerScaffold(navController) {
                HomeScreen()
          //  }
        }
    }
}