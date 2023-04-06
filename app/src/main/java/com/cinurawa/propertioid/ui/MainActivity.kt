package com.cinurawa.propertioid.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.navigation.Screen
import com.cinurawa.propertioid.ui.organisms.NavDrawer
import com.cinurawa.propertioid.ui.organisms.NavTopBar
import com.cinurawa.propertioid.ui.pages.agent.AgentScreen
import com.cinurawa.propertioid.ui.pages.detail_agent.DetailAgentScreen
import com.cinurawa.propertioid.ui.pages.detail_project.DetailProjectScreen
import com.cinurawa.propertioid.ui.pages.detail_properti.DetailPropertiScreen
import com.cinurawa.propertioid.ui.pages.detail_unit.DetailUnitScreen
import com.cinurawa.propertioid.ui.pages.developer.DeveloperScreen
import com.cinurawa.propertioid.ui.pages.home.HomeScreen
import com.cinurawa.propertioid.ui.pages.project.ProjectScreen
import com.cinurawa.propertioid.ui.pages.properti.PropertiScreen
import com.cinurawa.propertioid.ui.pages.webview.WebViewScreen
import com.cinurawa.propertioid.ui.theme.PropertioidTheme
import com.cinurawa.propertioid.ui.utils.rememberNavDrawerState
import com.cinurawa.propertioid.utils.decodeUrl
import com.cinurawa.propertioid.utils.encodeUrl
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalPagerApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PropertioidTheme {
                PropertioidApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun PropertioidApp(
    modifier: Modifier = Modifier
) {
    val appState = rememberNavDrawerState()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = appState.scaffoldState,
        topBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            NavTopBar(
                onMenuClick = appState::onMenuClick,
                onBackClick = {
                    navController.popBackStack()
                },
                route = currentRoute ?: ""
            )
        },
        drawerContent = {
            NavDrawer(
                onItemSelected = {
                    appState.onItemSelected()
                    navController.navigate(it)
                },
                onBackPress = appState::onBackPress,
            )
        },
        drawerGesturesEnabled = appState.scaffoldState.drawerState.isOpen,
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    onPropertyClicked = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "property",
                            it
                        )
                        navController.navigate(Screen.DetailProperti.createRoute(it.id))
                    },
                    onProjectClicked = {
                        navController.navigate(Screen.DetailProject.createRoute(it))
                    }
                )
            }
            composable(Screen.Properti.route) {
                PropertiScreen(
                    onPropertiClicked = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "property",
                            it
                        )
                        navController.navigate(Screen.DetailProperti.createRoute(it.id))
                    }
                )
            }
            composable(Screen.Project.route) {
                ProjectScreen(
                    onProjectClicked = {
                        navController.navigate(Screen.DetailProject.createRoute(it))
                    }
                )
            }
            composable(Screen.Agent.route) {
                AgentScreen(
                    onAgentClicked = {
                        navController.navigate(Screen.DetailAgent.createRoute(it))
                    }
                )
            }
            composable(Screen.Developer.route) {
                DeveloperScreen()
            }
            composable(
                route = Screen.DetailProperti.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                val data = navController.previousBackStackEntry?.savedStateHandle?.get<Property>(
                    "property"
                )
                DetailPropertiScreen(
                    data = data,
                    onVirtualTourClick = {
                        navController.navigate(Screen.VirtualTour.createRoute(encodeUrl(it)))
                    }
                )
            }
            composable(
                route = Screen.DetailProject.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id") ?: 1
                DetailProjectScreen(
                    id = id,
                    onUnitClicked = { unitId ->
                        navController.navigate(Screen.DetailUnit.createRoute(unitId))
                    }
                )
            }
            composable(
                route = Screen.DetailUnit.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                val id = it.arguments?.getInt("id") ?: 1
                DetailUnitScreen(
                    id = id
                )
            }
            composable(
                route = Screen.DetailAgent.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getInt("id") ?: 1
                DetailAgentScreen(
                    id = id,
                    onPropertyClicked = {
                        navController.navigate(Screen.DetailProperti.createRoute(it))
                    },
                )
            }

            composable(
                route = Screen.VirtualTour.route,
                arguments = listOf(navArgument("url") { type = NavType.StringType })
            ) { navBackStackEntry ->
                val url = navBackStackEntry.arguments?.getString("url") ?: ""
                WebViewScreen(
                    url = decodeUrl(url)
                )

            }




        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PropertioidTheme {
    }
}