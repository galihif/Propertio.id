package com.cinurawa.propertioid.ui.navigation


sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Properti : Screen("Properti")
    object DetailProperti : Screen("DetailProperti/{id}") {
        fun createRoute(id: Int) = "DetailProperti/$id"
    }
    object DetailProject : Screen("DetailProject/{id}") {
        fun createRoute(id: Int) = "DetailProject/$id"
    }
    object DetailUnit : Screen("DetailUnit/{id}") {
        fun createRoute(id: Int) = "DetailUnit/$id"
    }

    object DetailAgent : Screen("DetailAgent/{id}") {
        fun createRoute(id: Int) = "DetailAgent/$id"
    }

    object VirtualTour : Screen("VirtualTour/{url}") {
        fun createRoute(url: String) = "VirtualTour/$url"
    }




    object Project : Screen("Project")
    object Agent : Screen("Agent")
    object Developer : Screen("Developer")
}