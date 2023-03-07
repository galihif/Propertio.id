package com.cinurawa.propertioid.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.component.HomeBanner
import com.cinurawa.propertioid.ui.component.HomeCarousel
import com.cinurawa.propertioid.ui.component.HomeSearchCard
import com.cinurawa.propertioid.ui.component.HomeTab
import com.cinurawa.propertioid.ui.component.button.ButtonLihatSemua
import com.cinurawa.propertioid.ui.component.item.ItemProject
import com.cinurawa.propertioid.ui.component.item.ItemProperty
import com.cinurawa.propertioid.ui.component.text.HomeSectionTitle
import com.cinurawa.propertioid.ui.theme.Blue700
import com.cinurawa.propertioid.ui.theme.DarkBlue500
import com.cinurawa.propertioid.utils.Type
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    var selectedMenu by remember { mutableStateOf(HomeTab.Beli) }

    var selectedOption by remember { mutableStateOf("") }
    val listOptions = listOf(
        Type.Apartemen.value,
        Type.Gudang.value,
        Type.Kondominium.value,
        Type.Kosan.value,
        Type.Pabrik.value,
        Type.Perkantoran.value,
        Type.RuangUsaha.value,
        Type.Ruko.value,
        Type.Rumah.value,
        Type.RumahKuno.value,
        Type.Tanah.value,
        Type.Villa.value
    )

    var keyword by remember { mutableStateOf("") }

    LaunchedEffect(selectedOption) {
        if (selectedOption != "") {
            Toast.makeText(context, selectedOption, Toast.LENGTH_SHORT).show()
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HomeBanner()
                HomeTab(selectedMenu) {
                    selectedMenu = it
                }
                HomeSearchCard(
                    options = listOptions,
                    onOptionSelected = { selectedOption = it },
                    selectedOption = selectedOption,
                    keyword = keyword,
                    onKeywordChanged = { keyword = it }
                )
                HomeCarousel(modifier = Modifier.fillMaxWidth())
            }
        }
        item {
            HomeSectionTitle(
                title = "Rekomendasi Properti",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(3) {
            ItemProperty()
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            ButtonLihatSemua(Modifier.fillMaxWidth()) {

            }
        }
        item {
            HomeSectionTitle(
                title = "Project Pilihan",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(3) {
            ItemProject()
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            ButtonLihatSemua(Modifier.fillMaxWidth()) {

            }
        }
        item {
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
            Spacer(modifier =Modifier.height(14.dp))
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
    }
}


