package com.example.assign.ui.navigation

enum class Rout {
    MenuBar,
    ExploreScreen,
    RefineScreen;
    companion object {
        fun fromRoute(route: String): Rout = when(route.substringBefore("/")){
            MenuBar.name -> MenuBar
            ExploreScreen.name ->  ExploreScreen
            RefineScreen.name -> RefineScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
        }
    }
}