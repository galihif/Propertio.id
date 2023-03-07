package com.cinurawa.propertioid.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.component.HomeBanner
import com.cinurawa.propertioid.ui.component.HomeCarousel
import com.cinurawa.propertioid.ui.component.HomeSearchCard
import com.cinurawa.propertioid.ui.component.HomeTab
import com.cinurawa.propertioid.ui.component.button.ButtonLihatSemua
import com.cinurawa.propertioid.ui.component.item.ItemProperty
import com.cinurawa.propertioid.ui.component.text.HomeSectionTitle
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
        }
        items(10) {
            ItemProperty()
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            ButtonLihatSemua(Modifier.fillMaxWidth()){

            }
        }
        item {
            HomeSectionTitle(
                title = "Project Pilihan",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


