package com.cinurawa.propertioid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cinurawa.propertioid.ui.component.TopBar
import com.cinurawa.propertioid.ui.component.drawer.MyDrawerContent
import com.cinurawa.propertioid.ui.component.drawer.rememberMyNavDrawerState
import com.cinurawa.propertioid.ui.navigation.Screen
import com.cinurawa.propertioid.ui.screen.agent.AgentScreen
import com.cinurawa.propertioid.ui.screen.developer.DeveloperScreen
import com.cinurawa.propertioid.ui.screen.home.HomeScreen
import com.cinurawa.propertioid.ui.screen.project.ProjectScreen
import com.cinurawa.propertioid.ui.screen.properti.PropertiScreen
import com.cinurawa.propertioid.ui.theme.PropertioidTheme

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

@Composable
fun PropertioidApp(
    modifier: Modifier = Modifier
) {
    val appState = rememberMyNavDrawerState()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = appState.scaffoldState,
        topBar = {
            TopBar(
                onMenuClick = appState::onMenuClick
            )
        },
        drawerContent = {
            MyDrawerContent(
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