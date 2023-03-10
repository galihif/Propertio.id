package com.cinurawa.propertioid.ui.navigation


sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Properti : Screen("Properti")
    object DetailProperti : Screen("DetailProperti/{id}") {
        fun createRoute(id: Int) = "DetailProperti/$id"
    }
    object Project : Screen("Project")
    object Agent : Screen("Agent")
    object Developer : Screen("Developer")
}