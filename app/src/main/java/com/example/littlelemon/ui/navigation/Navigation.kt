package com.example.littlelemon.ui.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.database.MenuItem
import com.example.littlelemon.ui.navigation.Home
import com.example.littlelemon.ui.navigation.Onboarding
import com.example.littlelemon.ui.navigation.Profile
import com.example.littlelemon.ui.screens.Home
import com.example.littlelemon.ui.screens.Onboarding
import com.example.littlelemon.ui.screens.Profile

@Composable
fun Navigation(isLogged: Boolean, sharedPreferences: SharedPreferences, menuItems: List<MenuItem>) {
    //choosing start navigation based on logged in status in shared preferences
    val startDestination = if (!isLogged) Onboarding.route else Home.route
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            Onboarding(navController = navController, sharedPreferences)
        }
        composable(Home.route) {
            Home(navController = navController, menuItems = menuItems)
        }
        composable(Profile.route) {
            Profile(navController = navController, sharedPreferences)
        }
    }
}