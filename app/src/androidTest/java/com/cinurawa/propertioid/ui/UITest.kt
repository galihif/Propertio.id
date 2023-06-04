package com.cinurawa.propertioid.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.ui.navigation.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@LargeTest
class UITest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @ExperimentalMaterialApi
    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var mainRepository: MainRepository

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun test_list_property() = runTest {
        composeTestRule.onNodeWithContentDescription("home_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
        }
        mainRepository.getAllProperty().collect {
            it.data?.forEach { property ->
                composeTestRule.onNodeWithText(property.name).assertExists()
            }
        }
    }

    @Test
    fun test_list_project() = runTest {
        composeTestRule.onNodeWithContentDescription("home_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
        }
        mainRepository.getAllProject().collect {
            it.data?.forEach { project ->
                composeTestRule.onNodeWithText(project.name).assertExists()
            }
        }
    }

    @Test
    fun test_search_property() = runTest{
        composeTestRule.onNodeWithContentDescription("home_search").assertExists()
        composeTestRule.onNodeWithText("Tipe Properti").performClick()
        composeTestRule.onNodeWithText("Rumah").performClick()
        composeTestRule.onNodeWithText("Tipe Listing").performClick()
        composeTestRule.onNodeWithText("Beli").performClick()
        composeTestRule.onNodeWithText("Cari properti disini...").performTextInput("Melati")
        composeTestRule.onNodeWithText("Cari").performClick()
        composeTestRule.onNodeWithTag("properti_screen").assertExists()
    }

    @Test
    fun test_menu_click() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Home.route).assertExists()
        composeTestRule.onNodeWithText(Screen.Properti.title?:"").assertExists()
        composeTestRule.onNodeWithText(Screen.Project.title?:"").assertExists()
        composeTestRule.onNodeWithText(Screen.Agent.route).assertExists()
        composeTestRule.onNodeWithText(Screen.Developer.route).assertExists()
    }

    @Test
    fun test_go_to_properti_menu() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Properti.title?:"").performClick()
        composeTestRule.onNodeWithTag("properti_screen").assertExists()
    }

    @Test
    fun test_go_to_project_menu() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Project.title?:"").performClick()
        composeTestRule.onNodeWithTag("project_screen").assertExists()
    }

    @Test
    fun test_go_to_agent_menu() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Agent.route).performClick()
        composeTestRule.onNodeWithTag("agent_screen").assertExists()
    }

    @Test
    fun test_go_to_developer_menu() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Developer.route).performClick()
        composeTestRule.onNodeWithTag("developer_screen").assertExists()
    }
}