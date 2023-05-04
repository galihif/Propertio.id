package com.cinurawa.propertioid.ui.home

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.ui.MainActivity
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
class HomeScreenTest {
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
            onChildren().printToLog("GALIH")
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
            onChildren().printToLog("GALIH AFTER SCROLL")
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
            onChildren().printToLog("GALIH")
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
            onChildren().printToLog("GALIH AFTER SCROLL")
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
            onChildren().printToLog("GALIH AFTER SCROLL2")
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
            onChildren().printToLog("GALIH AFTER SCROLL3")
        }
        mainRepository.getAllProject().collect {
            it.data?.forEach { project ->
                composeTestRule.onNodeWithText(project.name).assertExists()
            }
        }
    }
}