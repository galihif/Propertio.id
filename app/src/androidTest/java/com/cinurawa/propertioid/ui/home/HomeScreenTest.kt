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
    fun test_home() = runTest {
        composeTestRule.onNodeWithTag("home_banner").assertExists()
        composeTestRule.onNodeWithTag("home_banner").assertIsDisplayed()

        composeTestRule.onNodeWithTag("home_tab").assertExists()
        composeTestRule.onNodeWithTag("home_tab").assertIsDisplayed()

        composeTestRule.onNodeWithTag("home_search_box").assertExists()
        composeTestRule.onNodeWithTag("home_search_box").assertIsDisplayed()

        composeTestRule.onNodeWithTag("home_search_box").performScrollTo()

        composeTestRule.onNodeWithTag("rekomendasi_properti").assertExists()
        composeTestRule.onNodeWithTag("rekomendasi_properti").assertIsDisplayed()
    }

}