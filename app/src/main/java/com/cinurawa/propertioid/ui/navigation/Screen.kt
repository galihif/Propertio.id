package com.cinurawa.propertioid.ui.navigation


sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Properti : Screen("Properti")
    object DetailProperti : Screen("DetailProperti/{slug}") {
        fun createRoute(slug: String) = "DetailProperti/$slug"
    }
    object DetailProject : Screen("DetailProject/{slug}") {
        fun createRoute(slug: String) = "DetailProject/$slug"
    }
    object DetailUnit : Screen("DetailUnit/{id}") {
        fun createRoute(id: Int) = "DetailUnit/$id"
    }

    object DetailAgent : Screen("DetailAgent/{id}") {
        fun createRoute(id: Int) = "DetailAgent/$id"
    }

    object DetailDeveloper : Screen("DetailDeveloper/{id}") {
        fun createRoute(id: Int) = "DetailDeveloper/$id"
    }

    object Webview : Screen("Webview/{url}") {
        fun createRoute(url: String) = "Webview/$url"
    }

    object Project : Screen("Project")
    object Agent : Screen("Agent")
    object Developer : Screen("Developer")
}