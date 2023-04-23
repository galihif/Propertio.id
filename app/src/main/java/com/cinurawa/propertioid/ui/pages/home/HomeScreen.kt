package com.cinurawa.propertioid.ui.pages.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.atoms.LihatSemuaButton
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.ErrorColumn
import com.cinurawa.propertioid.ui.molecules.HomeBanner
import com.cinurawa.propertioid.ui.organisms.*
import com.cinurawa.propertioid.ui.theme.Blue700
import com.cinurawa.propertioid.ui.theme.DarkBlue500
import com.cinurawa.propertioid.ui.utils.DataProvider
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    onPropertyClicked: (Property) -> Unit = {},
    onProjectClicked: (Project) -> Unit = {},
    onLihatSemuaPropertyClicked: () -> Unit = {},
    onLihatSemuaProjectClicked: () -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    var selectedMenu by remember { mutableStateOf(HomeTab.Beli) }

    var selectedOption by remember { mutableStateOf("") }
    val listOptions = DataProvider.typeList()

    var keyword by remember { mutableStateOf("") }

    val listProperty by remember {
        viewModel.listProperty
    }.collectAsState()

    val listProject by remember {
        viewModel.listProject
    }.collectAsState()

    val isPropertyLoading by remember {
        viewModel.isPropertyLoading
    }.collectAsState()

    val isProjectLoading by remember {
        viewModel.isProjectLoading
    }.collectAsState()

    val error by remember {
        viewModel.error
    }.collectAsState()

    LaunchedEffect(error) {
        if (error.isNotEmpty()) {
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
    }

    if (error.isNotEmpty()){
        ErrorColumn(error = error)
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.Top
        ) {
            item {
                HomeBanner(
                    modifier = Modifier.testTag("home_banner")
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                HomeTab(
                    Modifier.testTag("home_tab"),
                    selectedMenu
                ) {
                    selectedMenu = it
                }
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                PropertySearchBox(
                    Modifier.testTag("home_search_box"),
                    options = listOptions,
                    onOptionSelected = { selectedOption = it },
                    selectedOption = selectedOption,
                    keyword = keyword,
                    onKeywordChanged = { keyword = it }
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                HomeCarousel(modifier = Modifier.fillMaxWidth().testTag("home_carousel"))
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                TitleSectionText(
                    title = "Rekomendasi Properti",
                    modifier = Modifier.testTag("rekomendasi_properti").fillMaxWidth()
                )
            }
            item {
                if (isPropertyLoading) {
                    Spacer(modifier = Modifier.height(24.dp))
                    LoadingItem()
                    LoadingItem()
                }
            }
            items(listProperty) { property ->
                Spacer(modifier = Modifier.height(24.dp))
                PropertyItem(
                    onDetailClicked = { onPropertyClicked(property) },
                    data = property
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                LihatSemuaButton(
                    Modifier.fillMaxWidth(),
                    onClick = onLihatSemuaPropertyClicked
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                TitleSectionText(
                    title = "Project Pilihan",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                if (isProjectLoading) {
                    Spacer(modifier = Modifier.height(24.dp))
                    LoadingItem()
                    LoadingItem()
                }
            }
            items(listProject) {
                Spacer(modifier = Modifier.height(24.dp))
                ProjectItem(
                    onDetailClicked = { onProjectClicked(it) },
                    data = it
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                LihatSemuaButton(
                    Modifier.fillMaxWidth(),
                    onClick = onLihatSemuaProjectClicked
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = 0.dp,
                    backgroundColor = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Column(
                        Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_market_outlook),
                            contentDescription = ""
                        )
                        Text(
                            "Priopertio.com Indonesia Property Market Outlook 2023",
                            color = MaterialTheme.colors.onPrimary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.surface,
                                contentColor = MaterialTheme.colors.primary
                            ),
                            contentPadding = PaddingValues(10.dp),
                            elevation = ButtonDefaults.elevation(0.dp)
                        ) {
                            Text("Selengkapnya")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(14.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        elevation = 0.dp,
                        backgroundColor = DarkBlue500,
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Column(
                            Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                "Baca cerita inspiratif para pencari hunian",
                                color = MaterialTheme.colors.onPrimary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Button(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = MaterialTheme.colors.surface,
                                    contentColor = DarkBlue500
                                ),
                                contentPadding = PaddingValues(10.dp),
                                elevation = ButtonDefaults.elevation(0.dp)
                            ) {
                                Text("Cerita Rumah")
                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        elevation = 0.dp,
                        backgroundColor = Blue700,
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Column(
                            Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                "Simak sentimen pencari hunian di Indonesia",
                                color = MaterialTheme.colors.onPrimary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Button(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = MaterialTheme.colors.surface,
                                    contentColor = Blue700
                                ),
                                contentPadding = PaddingValues(10.dp),
                                elevation = ButtonDefaults.elevation(0.dp)
                            ) {
                                Text("CSS H2 2022")
                            }
                        }
                    }

                }
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Card(
                    Modifier.wrapContentSize(),
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = MaterialTheme.colors.primary,
                ) {
                    Column(
                        Modifier.fillMaxWidth()
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)),
                            painter = painterResource(id = R.drawable.home_banner),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            Modifier.padding(14.dp)
                        ) {
                            Text(
                                "Mari kami pandu ke rumah Impianmu",
                                color = MaterialTheme.colors.onPrimary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = MaterialTheme.colors.surface,
                                    contentColor = MaterialTheme.colors.primary
                                ),
                                contentPadding = PaddingValues(10.dp),
                                elevation = ButtonDefaults.elevation(0.dp)
                            ) {
                                Text("Selengkapnya")
                            }
                        }
                    }
                }
            }
        }
    }
}


