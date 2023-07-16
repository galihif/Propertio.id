package com.cinurawa.propertioid.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.matcher.IntentMatchers.hasPackage
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
import org.hamcrest.Matchers
import org.junit.After
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
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun melihat_rekomendasi_properti() = runTest {
        composeTestRule.onNodeWithTag("home_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 400)
                swipeUp(durationMillis = 400)
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
        composeTestRule.onNodeWithTag("home_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 400)
                swipeUp(durationMillis = 400)
                swipeUp(durationMillis = 400)
            }
        }
        composeTestRule.waitUntil {
            composeTestRule.onAllNodes(hasText("Project Pilihan")).fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule.onNodeWithText("Project Pilihan").assertIsDisplayed()
        mainRepository.getAllProject().collect {
            it.data?.forEach { project ->
                composeTestRule.onNodeWithText(project.name).assertExists()
            }
        }
    }

    @Test
    fun mencari_properti() = runTest {
        val dummyProperti = DummyData.listProperty()[0]
        composeTestRule.apply {
            onNodeWithTag("home_search").assertExists()
            onNodeWithText("Tipe Properti").performClick()
            onNodeWithText("Rumah").performClick()
            onNodeWithText("Tipe Listing").performClick()
            onNodeWithText("Beli").performClick()
            onNodeWithText("Cari properti disini...").performTextInput(dummyProperti.name)
            onNodeWithText("Cari").performClick()
            onNodeWithTag("properti_screen").assertExists()
            onNodeWithTag("properti_screen").performTouchInput {
                swipeUp(durationMillis = 400)
            }
            onNodeWithText(dummyProperti.desc).assertExists()
            onNodeWithText(dummyProperti.address).assertExists()
        }
    }
    @Test
    fun mencari_properti_kosong() = runTest {
        composeTestRule.apply {
            onNodeWithTag("home_search").assertExists()
            onNodeWithText("Cari properti disini...").performTextInput("asdasd")
            onNodeWithText("Cari").performClick()
            onNodeWithTag("empty_state").assertExists()
        }
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
        composeTestRule.onNodeWithTag("properti_screen").performTouchInput {
            swipeUp(durationMillis = 400)
        }
        mainRepository.getAllProperty().collect {
            it.data?.forEach { property ->
                composeTestRule.onNodeWithText(property.name).assertExists()
            }
        }
    }

    @Test
    fun membuka_halaman_proyek() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Project.title ?: "").performClick()
        composeTestRule.onNodeWithTag("project_screen").apply {
            assertExists()
            performTouchInput {
                swipeUp(durationMillis = 400)
            }
        }
        mainRepository.getAllProject().collect {
            it.data?.forEach { project ->
                composeTestRule.onNodeWithText(project.name).assertExists()
            }
        }
    }

    @Test
    fun membuka_halaman_agen() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Agent.route).performClick()
        composeTestRule.onNodeWithTag("agent_screen").apply {
            assertExists()
            performTouchInput {
                swipeUp(durationMillis = 400)
            }
        }
        mainRepository.getAllAgent().collect {
            it.data?.forEach { agent ->
                composeTestRule.onNodeWithText(agent.name).assertExists()
            }
        }
    }

    @Test
    fun membuka_halaman_pengembang() = runTest {
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Developer.route).performClick()
        composeTestRule.onNodeWithTag("developer_screen").apply {
            assertExists()
            performTouchInput {
                swipeUp(durationMillis = 400)
            }
        }
        mainRepository.getAllDeveloper().collect {
            it.data?.forEach { developer ->
                composeTestRule.onNodeWithText(developer.name).assertExists()
            }
        }
    }

    @Test
    fun melihat_detail_properti() = runTest {
        //Go to properti screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Properti.title ?: "").performClick()
        composeTestRule.onNodeWithTag("properti_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }

        //Go to detail properti screen
        val dummyProperty = DummyData.listProperty()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyProperty.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_properti_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }

        //Check detail properti screen
        val detailPropertiScreen = composeTestRule.onNodeWithTag("detail_properti_screen")
        detailPropertiScreen.assertIsDisplayed()

        composeTestRule.apply {
            onNodeWithTag("image_carousel").assertIsDisplayed()
            onNodeWithTag("label").assertIsDisplayed()
            onNodeWithText(dummyProperty.name).assertIsDisplayed()
            onNodeWithText(dummyProperty.address).assertIsDisplayed()
            onNodeWithText("Rp ${formatHarga(dummyProperty.price.toLong())}")
                .assertIsDisplayed()
            onNodeWithText(dummyProperty.desc).assertIsDisplayed()
            onNodeWithTag("property_attribute").assertIsDisplayed()

            detailPropertiScreen.performTouchInput { swipeUp(durationMillis = 1000) }
            waitUntil {
                onAllNodesWithTag("spesifikasi").fetchSemanticsNodes().isNotEmpty()
            }
            onNodeWithTag("spesifikasi").assertIsDisplayed()
            onNodeWithTag("btn_virtual_tour").assertIsDisplayed()
            onNodeWithTag("video_player").assertIsDisplayed()

            detailPropertiScreen.performTouchInput { swipeUp(durationMillis = 1000) }
            onAllNodesWithTag("btn_peta_lokasi").fetchSemanticsNodes().isNotEmpty()
            onNodeWithTag("btn_peta_lokasi").assertIsDisplayed()
            dummyProperty.dokumen?.forEach {
                composeTestRule.onNodeWithText(it.nama).assertIsDisplayed()
            }
            onNodeWithTag("fasilitas").assertIsDisplayed()
            onNodeWithTag("infrastruktur").assertIsDisplayed()

            detailPropertiScreen.performTouchInput { swipeUp(durationMillis = 1000) }
            waitUntil {
                onAllNodesWithTag("contact_row").fetchSemanticsNodes().isNotEmpty()
            }
            onNodeWithTag("contact_row").assertIsDisplayed()
        }
    }

    @Test
    fun melihat_detail_proyek() = runTest {
        //Go to project screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Project.title ?: "").performClick()
        composeTestRule.onNodeWithTag("project_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }

        //Go to detail project screen
        val dummyProject = DummyData.listProject()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyProject.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_project_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        val detailProjectScreen = composeTestRule.onNodeWithTag("detail_project_screen")
        detailProjectScreen.assertIsDisplayed()

        //Check content
        composeTestRule.apply {
            onNodeWithTag("image_carousel").assertIsDisplayed()
            onNodeWithTag("label").assertIsDisplayed()
            onNodeWithText(dummyProject.name).assertIsDisplayed()
            onNodeWithText("Kode Proyek : ${dummyProject.code}").assertIsDisplayed()
            onNodeWithText(dummyProject.address).assertIsDisplayed()
            onNodeWithTag("harga").assertIsDisplayed()
            onNodeWithText(dummyProject.desc).assertIsDisplayed()
            onNodeWithText(dummyProject.concept).assertIsDisplayed()

            onNodeWithTag("detail_project_screen").performTouchInput {
                swipeUp(durationMillis = 3000)
            }
            onNodeWithText("Daftar Unit").assertIsDisplayed()
            dummyProject.listUnit.forEach {
                onNodeWithText(it.name).assertIsDisplayed()
            }

            onNodeWithText("Lihat Virtual Tour").assertIsDisplayed()
            onNodeWithTag("detail_project_screen").performTouchInput {
                swipeUp(durationMillis = 3000)
            }
            onNodeWithText("Lihat 3D Site Plan").assertIsDisplayed()
            onNodeWithText("Download App").assertIsDisplayed()
            onNodeWithTag("video_player").assertIsDisplayed()
            onNodeWithText("Lihat Peta Lokasi").assertIsDisplayed()
            dummyProject.dokumen.forEach {
                onNodeWithText(it.nama).assertIsDisplayed()
            }
            onNodeWithTag("detail_project_screen").performTouchInput {
                swipeUp(durationMillis = 3000)
            }
            dummyProject.fasilitas.forEach {
                onNodeWithText(it).assertIsDisplayed()
            }
            dummyProject.infrastruktur.forEach {
                onNodeWithText(it.name).assertIsDisplayed()
            }
            onNodeWithText(dummyProject.agentName).assertIsDisplayed()
        }
    }

    @Test
    fun melihat_detail_agen() = runTest {
        //Go to agent screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Agent.route).performClick()
        composeTestRule.onNodeWithTag("agent_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }
        val dummyAgent = DummyData.listAgents()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyAgent.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_agent_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule.apply {
            onNodeWithTag("detail_agent_screen").assertIsDisplayed()
            onNodeWithTag("thumbnail_image").assertIsDisplayed()
            onNodeWithText(dummyAgent.name).assertIsDisplayed()
            onNodeWithText(dummyAgent.address).assertIsDisplayed()
            onNodeWithText("${dummyAgent.propertyCount} Properti").assertIsDisplayed()
            onNodeWithText("${dummyAgent.propertySold} Terjual").assertIsDisplayed()
            onNodeWithText("${dummyAgent.propertyRented} Tersewa").assertIsDisplayed()
            onNodeWithText(dummyAgent.phone).assertIsDisplayed()

            onNodeWithTag("detail_agent_screen").performTouchInput {
                swipeUp(durationMillis = 1000)
                swipeUp(durationMillis = 1000)
                swipeUp(durationMillis = 1000)
            }
            dummyAgent.propertyList.forEach {
                onNodeWithText(it.name).assertExists()
            }
        }
    }

    @Test
    fun melihat_detail_pengembang() = runTest {
        //Go to developer screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Developer.route).performClick()
        composeTestRule.onNodeWithTag("developer_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }
        val dummyDeveloper = DummyData.listDevelopers()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyDeveloper.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_developer_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule.apply {
            onNodeWithTag("detail_developer_screen").assertIsDisplayed()
            onNodeWithTag("thumbnail_image").assertIsDisplayed()
            onNodeWithText(dummyDeveloper.name).assertIsDisplayed()
            onNodeWithText(dummyDeveloper.address).assertIsDisplayed()
            onNodeWithText("${dummyDeveloper.projectCount} Project").assertIsDisplayed()
            onNodeWithText(dummyDeveloper.phone).assertIsDisplayed()
            onNodeWithTag("detail_developer_screen").performTouchInput {
                swipeUp(durationMillis = 1000)
            }
            dummyDeveloper.projectList.forEach {
                onNodeWithText(it.name).assertExists()
            }
        }
    }

    @Test
    fun melihat_detail_unit() = runTest {
        //Go to project screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Project.title ?: "").performClick()
        composeTestRule.onNodeWithTag("project_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }
        val dummyProject = DummyData.listProject()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyProject.id}").performClick()

        val detailProjectScreen = composeTestRule.onNodeWithTag("detail_project_screen")
        detailProjectScreen.assertIsDisplayed()
        detailProjectScreen.performTouchInput {
            swipeUp(durationMillis = 1000)
        }

        val dummyUnit = dummyProject.listUnit[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyUnit.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_unit_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule.apply {
            onNodeWithTag("detail_unit_screen").assertIsDisplayed()
            onNodeWithTag("image_carousel").assertIsDisplayed()
            onNodeWithText(dummyUnit.name).assertIsDisplayed()
            onNodeWithText(dummyUnit.type).assertIsDisplayed()
            onNodeWithText("Kode Unit : ${dummyUnit.code}").assertIsDisplayed()
            onNodeWithText("Rp ${formatHarga(dummyUnit.price.toLong())}").assertIsDisplayed()
            onNodeWithText(dummyUnit.desc).assertIsDisplayed()
            onNodeWithText(dummyUnit.spec).assertIsDisplayed()
        }
    }

    @Test
    fun melihat_virtual_tour() = runTest {
        //Go to properti screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Properti.title ?: "").performClick()
        composeTestRule.onNodeWithTag("properti_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }
        val dummyProperti = DummyData.listProperty()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyProperti.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_properti_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        val detailPropertiScreen = composeTestRule.onNodeWithTag("detail_properti_screen")
        detailPropertiScreen.assertIsDisplayed()
        detailPropertiScreen.performTouchInput {
            swipeUp(durationMillis = 1000)
        }
        composeTestRule.apply {
            onNodeWithTag("btn_virtual_tour").assertIsDisplayed()
            onNodeWithTag("btn_virtual_tour").performClick()
            waitUntil {
                onAllNodesWithTag("webview_loaded").fetchSemanticsNodes().isNotEmpty()
            }
            onNodeWithTag("webview_loaded").assertIsDisplayed()
        }
    }

    @Test
    fun melihat_lokasi() = runTest {
        //Go to properti screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Properti.title ?: "").performClick()
        composeTestRule.onNodeWithTag("properti_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }
        val dummyProperti = DummyData.listProperty()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyProperti.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_properti_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        val detailPropertiScreen = composeTestRule.onNodeWithTag("detail_properti_screen")
        detailPropertiScreen.assertIsDisplayed()
        detailPropertiScreen.performTouchInput {
            swipeUp(durationMillis = 1000)
            swipeUp(durationMillis = 1000)
        }
        composeTestRule.apply {
            onNodeWithTag("btn_peta_lokasi").assertExists()
            onNodeWithTag("btn_peta_lokasi").performClick()
            val expectedIntent = Matchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasPackage("com.google.android.apps.maps"),
            )
            intended(expectedIntent)
        }
    }

    @Test
    fun mengunduh_dokumen() = runTest {
        //Go to properti screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Properti.title ?: "").performClick()
        composeTestRule.onNodeWithTag("properti_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }
        val dummyProperti = DummyData.listProperty()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyProperti.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_properti_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        val detailPropertiScreen = composeTestRule.onNodeWithTag("detail_properti_screen")
        detailPropertiScreen.assertIsDisplayed()
        detailPropertiScreen.performTouchInput {
            swipeUp(durationMillis = 1000)
            swipeUp(durationMillis = 1000)
        }
        val dummyDokumen = dummyProperti.dokumen!![0]
        composeTestRule.apply {
            onNodeWithText(dummyDokumen.nama).assertExists()
            onNodeWithText(dummyDokumen.nama).performClick()
            val expectedIntent = Matchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse(dummyDokumen.link)),
            )
            intended(expectedIntent)
        }
    }

    @Test
    fun melihat_3d_siteplan() = runTest {
        //Go to project screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Project.title ?: "").performClick()
        composeTestRule.onNodeWithTag("project_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }

        //Go to detail project screen
        val dummyProject = DummyData.listProject()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyProject.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_project_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        val detailProjectScreen = composeTestRule.onNodeWithTag("detail_project_screen")
        detailProjectScreen.assertIsDisplayed()

        //Check content
        composeTestRule.apply {
            detailProjectScreen.performTouchInput {
                swipeUp(durationMillis = 3000)
                swipeUp(durationMillis = 3000)
            }
            onNodeWithTag("btn_3d_siteplan").assertIsDisplayed()
            onNodeWithTag("btn_3d_siteplan").performClick()
            waitUntil {
                onAllNodesWithTag("webview_loaded").fetchSemanticsNodes().isNotEmpty()
            }
            onNodeWithTag("webview_loaded").assertIsDisplayed()
        }
    }

    @Test
    fun mengunduh_ar_apps() = runTest {
        //Go to project screen
        composeTestRule.onNodeWithContentDescription("menu").performClick()
        composeTestRule.onNodeWithText(Screen.Project.title ?: "").performClick()
        composeTestRule.onNodeWithTag("project_screen").apply {
            performTouchInput {
                swipeUp(durationMillis = 1000)
            }
        }

        //Go to detail project screen
        val dummyProject = DummyData.listProject()[0]
        composeTestRule.onNodeWithTag("lihat_detail_${dummyProject.id}").performClick()
        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("detail_project_screen").fetchSemanticsNodes()
                .isNotEmpty()
        }
        val detailProjectScreen = composeTestRule.onNodeWithTag("detail_project_screen")
        detailProjectScreen.assertIsDisplayed()

        //Check content
        composeTestRule.apply {
            detailProjectScreen.performTouchInput {
                swipeUp(durationMillis = 1000)
                swipeUp(durationMillis = 1000)
            }
            onNodeWithText("Download App").assertIsDisplayed()
            onNodeWithText("Download App").performClick()

            val expectedIntent = Matchers.allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse(dummyProject.arApps)),
            )
            intended(expectedIntent)
        }
    }


}