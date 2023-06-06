package com.cinurawa.propertioid.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.cinurawa.propertioid.data.MainRepository
import com.cinurawa.propertioid.ui.navigation.Screen
import com.cinurawa.propertioid.ui.utils.formatHarga
import com.cinurawa.propertioid.utils.DummyData
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
    fun melihat_rekomendasi_properti() = runTest {
        composeTestRule.onNodeWithContentDescription("home_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
        }
        composeTestRule.onNodeWithText("Rekomendasi Properti").assertExists()
        mainRepository.getAllProperty().collect {
            it.data?.forEach { property ->
                composeTestRule.onNodeWithText(property.name).assertExists()
            }
        }
    }

    @Test
    fun melihat_proyek_pilihan() = runTest {
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
        composeTestRule.onNodeWithText("Project Pilihan").assertExists()
        mainRepository.getAllProject().collect {
            it.data?.forEach { project ->
                composeTestRule.onNodeWithText(project.name).assertExists()
            }
        }
    }

    @Test
    fun mencari_properti() = runTest {
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
    fun membuka_menu() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Home.route).assertExists()
        composeTestRule.onNodeWithText(Screen.Properti.title ?: "").assertExists()
        composeTestRule.onNodeWithText(Screen.Project.title ?: "").assertExists()
        composeTestRule.onNodeWithText(Screen.Agent.route).assertExists()
        composeTestRule.onNodeWithText(Screen.Developer.route).assertExists()
    }

    @Test
    fun membuka_halaman_properti() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Properti.title ?: "").performClick()
        composeTestRule.onNodeWithTag("properti_screen").assertExists()
    }

    @Test
    fun membuka_halaman_proyek() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Project.title ?: "").performClick()
        composeTestRule.onNodeWithTag("project_screen").assertExists()
    }

    @Test
    fun membuka_halaman_agen() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Agent.route).performClick()
        composeTestRule.onNodeWithTag("agent_screen").assertExists()
    }

    @Test
    fun membuka_halaman_pengembang() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Developer.route).performClick()
        composeTestRule.onNodeWithTag("developer_screen").assertExists()
    }

    @Test
    fun melihat_detail_properti() = runTest {
        //Go to properti screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Properti.title ?: "").performClick()
        composeTestRule.onNodeWithTag("properti_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 5000)
            }
        }

        //Go to detail properti screen
        val dummyProperty = DummyData.listProperty()[0]
        composeTestRule.onNodeWithTag("lihat_detail_1").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_properti_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }

        //Check detail properti screen
        val detailPropertiScreen = composeTestRule.onNodeWithTag("detail_properti_screen")
        detailPropertiScreen.assertIsDisplayed()

        //Check content
        composeTestRule.onNodeWithTag("image_carousel").assertIsDisplayed()
        composeTestRule.onNodeWithTag("label").assertIsDisplayed()

        composeTestRule.onNodeWithTag("title").assertIsDisplayed()
        composeTestRule.onNodeWithText(dummyProperty.name).assertIsDisplayed()

        composeTestRule.onNodeWithTag("lokasi").assertIsDisplayed()
        composeTestRule.onNodeWithText(dummyProperty.address).assertIsDisplayed()

        composeTestRule.onNodeWithTag("harga").assertIsDisplayed()
        composeTestRule.onNodeWithText("Rp ${formatHarga(dummyProperty.price.toLong())}").assertIsDisplayed()

        composeTestRule.onNodeWithTag("deskripsi").assertIsDisplayed()
        composeTestRule.onNodeWithText(dummyProperty.desc).assertIsDisplayed()

        composeTestRule.onNodeWithTag("property_attribute").assertIsDisplayed()

        //swipe up
        detailPropertiScreen.performTouchInput { swipeUp(durationMillis = 3000) }
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("spesifikasi").fetchSemanticsNodes().isNotEmpty()
        }
        composeTestRule.onNodeWithTag("spesifikasi").assertIsDisplayed()
        composeTestRule.onNodeWithTag("btn_virtual_tour").assertIsDisplayed()
        composeTestRule.onNodeWithTag("video_player").assertIsDisplayed()

        //swipe up
        detailPropertiScreen.performTouchInput { swipeUp(durationMillis = 3000) }
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("btn_peta_lokasi").fetchSemanticsNodes().isNotEmpty()
        }
        composeTestRule.onNodeWithTag("btn_peta_lokasi").assertIsDisplayed()
        dummyProperty.dokumen?.forEach {
            composeTestRule.onNodeWithText(it.nama).assertIsDisplayed()
        }
        composeTestRule.onNodeWithTag("fasilitas").assertIsDisplayed()
        composeTestRule.onNodeWithTag("infrastruktur").assertIsDisplayed()

        //swipe up
        detailPropertiScreen.performTouchInput { swipeUp(durationMillis = 3000) }
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("contact_row").fetchSemanticsNodes().isNotEmpty()
        }
        composeTestRule.onNodeWithTag("contact_row").assertIsDisplayed()
    }
}