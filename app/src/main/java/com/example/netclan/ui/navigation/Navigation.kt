package com.example.assign.ui.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assign.ui.screen.explore.ExploreScreen
import com.example.assignment.ui.component.MenuBar
import com.example.assignment.ui.screens.Refine

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rout.MenuBar.name){
        composable(Rout.MenuBar.name){
            MenuBar(navController)
        }
        composable(Rout.ExploreScreen.name){
            ExploreScreen(navController, drawerState = rememberDrawerState(initialValue = DrawerValue.Closed), scope = rememberCoroutineScope())
        }
        composable(Rout.RefineScreen.name){
            Refine(navController)
        }
    }
}