package com.cinurawa.propertioid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cinurawa.propertioid.ui.organisms.NavTopBar
import com.cinurawa.propertioid.ui.navigation.Screen
import com.cinurawa.propertioid.ui.organisms.NavDrawer
import com.cinurawa.propertioid.ui.pages.agent.AgentScreen
import com.cinurawa.propertioid.ui.pages.developer.DeveloperScreen
import com.cinurawa.propertioid.ui.pages.home.HomeScreen
import com.cinurawa.propertioid.ui.pages.project.ProjectScreen
import com.cinurawa.propertioid.ui.pages.properti.PropertiScreen
import com.cinurawa.propertioid.ui.theme.PropertioidTheme
import com.cinurawa.propertioid.ui.utils.rememberNavDrawerState
import com.google.accompanist.pager.ExperimentalPagerApi

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
            NavTopBar(
                onMenuClick = appState::onMenuClick
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
                HomeScreen()
            }
            composable(Screen.Properti.route) {
                PropertiScreen()
            }
            composable(Screen.Project.route) {
                ProjectScreen()
            }
            composable(Screen.Agent.route) {
                AgentScreen()
            }
            composable(Screen.Developer.route) {
                DeveloperScreen()
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